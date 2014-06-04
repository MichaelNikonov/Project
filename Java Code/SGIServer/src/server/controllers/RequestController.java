package server.controllers;

import java.io.*;
import java.util.*;
import sgi.entities.*;
import server.database.Database;
import server.models.DataPackage;
import ocsf.server.ConnectionToClient;

public class RequestController {

	// Enumerations
	public enum REQUESTS {
		LOGIN_USER, LOGOUT_USER,
		GET_ALL_CLIENTS, GET_CLIENT_BY_ID, GET_CLIENT_BY_USERNAME,
		ADD_CLIENT, UPDATE_CLIENT, REMOVE_CLIENT,
		GET_ALL_EMPLOYESS, GET_EMPLOYEE_BY_USERNAME,
		GET_ALL_COMPLAINTS, GET_UNSEEN_COMPLAINTS, GET_UNADDRESSED_COMPLAINTS,
		GET_COMPLAINT_BY_ID, ADD_COMPLAINT, UPDATE_COMPLAINT,
		GET_ALL_SUBSCRIPTIONS, GET_SUBSCRIPTION_BY_ID, GET_ACTIVATED_SUBSCRIPTIONS, 
		ADD_SUBSCRIPTION, ACTIVATE_SUBSCRIPTION, DEACTIVATE_SUBSCRIPTION,
		GET_ALL_LOCATIONS,
		GET_ALL_IMAGES, GET_IMAGES_BY_TITLE, GET_IMAGE_BY_ID,
		ADD_IMAGE, UPDATE_IMAGE,
		GET_ALL_LAYERS, GET_LAYER_BY_ID, GET_LAYERS_BY_IMAGEID,
		ADD_LAYER, REMOVE_LAYER,
		PURCHASE_IMAGE, DOWNLOAD_LAYER, PURCHASE_SUBSCRIPTION,
		GET_PRICES, SUGGEST_PRICES, APPROVE_PRICES, ACTIVATE_PRICES
	}
	// End of enumerations
	
	// Variables
	Database _db = null;
	// End of variables
	
	// Constructors
	/**
	 * Request Controller
	 * Construct the request controller with the supplied Database object
	 * @param db - Database object with database operations
	 */
	public RequestController(Database db) {
		_db = db;
	}
	// End of constructors
	
	// Methods
	/**
	 * Java Date To File Name String
	 * Convert Date to a string in the format of yyyy_MM_dd_hh_mm_ss
	 * @param value - The Date object
	 * @return A string in the format yyyy_MM_dd_hh_mm_ss
	 */
	@SuppressWarnings("deprecation")
	private String javaDateToFilenameString(Date value) {
		String ret="";
		if (value!=null) {
			ret += (value.getYear()+1900) + "_";
			ret += (value.getMonth()<9?"0"+(value.getMonth()+1):(value.getMonth()+1)) + "_";
			ret += (value.getDate()<10?"0"+value.getDate():value.getDate()) + "_";
			ret += (value.getHours()<10?"0"+value.getHours():value.getHours()) + "_";
			ret += (value.getMinutes()<10?"0"+value.getMinutes():value.getMinutes()) + "_";
			ret += (value.getSeconds()<10?"0"+value.getSeconds():value.getSeconds());			
		}
		return ret;
	}
	
	/**
	 * Handle Request
	 * Get a DataPackage object and process the request from it.
	 * @param msg - The DataPackage object
	 * @param client - The ConnectionToClient object for reply
	 */	
	public void handleRequest(DataPackage msg, ConnectionToClient client) {
		// REQUEST: Get All Locations
		if (msg.getRequestType()==REQUESTS.GET_ALL_LOCATIONS) {
			ArrayList<Location> data = _db.getLocations();
			msg.setData(data);
			try {
				client.sendToClient(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// REQUEST: Get All Images
		if (msg.getRequestType()==REQUESTS.GET_ALL_IMAGES) {
			ArrayList<SGIImage> data = _db.getImages();
			msg.setData(data);
			try {
				client.sendToClient(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// REQUEST: Get Image By Id
		if (msg.getRequestType()==REQUESTS.GET_IMAGE_BY_ID) {
			SGIImage data = _db.getImage((int)msg.getData());
			System.out.println("GET IMAGE " + (int)msg.getData());
			msg.setData(data);
			System.out.println("RETURN " + data.getLocation().getName());
			try {
				client.sendToClient(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// REQUEST: Add Image
		if (msg.getRequestType()==REQUESTS.ADD_IMAGE) {
			SGIImage temp = (SGIImage)msg.getData();
			_db.addImage(temp);
			try {
				BufferedOutputStream bos = null;
				FileOutputStream fos = new FileOutputStream(new File("images\\" +
						javaDateToFilenameString(temp.getDateTime()) + ".jpg"));
				bos = new BufferedOutputStream(fos);
				bos.write(temp.getImageBytes());
				bos.close();
				fos.close();
			}  catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
	// End of methods
}
