package client.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import client.main.IClient;
import client.main.MainClient;
import ocsf.client.*;
import server.controllers.RequestController;
import server.controllers.RequestController.REQUESTS;
import server.models.DataPackage;
import sgi.entities.Client;
import sgi.entities.Complaint;
import sgi.entities.ComplaintType;
import sgi.entities.Employee;
import sgi.entities.IComplaint;

public class ComplaintController implements IClient,IComplaint{
	
	
	private Complaint[] ServerResponse;
	private IClient clientForResponse;
	private MainClient clientForSend;
	public void ComplainController(MainClient client){
		this.clientForSend =  client;
		
	}

  public boolean addNewComplaint(Complaint ComplaintData){
	  REQUESTS req = RequestController.REQUESTS.ADD_NEW_COMPLAINT;
	  DataPackage toSend = new DataPackage(req,(Object)ComplaintData);
	  try { 
		     clientForSend.handleMessageFromClientUI((Object)toSend,null );
		     return true; 
		    } 
	  catch (Exception e){
		                   System.out.println(e.getMessage());
		                   return false;
		   }
	  
	  
  }
  Complaint[] SearchCompaint(String startDate){
	  Object Complaints = new Object();
	  //send message to database about which date we want the complaint
	  //database would return complaint array according to this date,including employee id
	  //and status
	  return (Complaint[])Complaints;
  }
  Complaint []SearchComplaint(String startDate,String title){
	  Object Complaints = new Object();
	  //send message to database to search in Complaint table according to date and title
	  //return Complaint array 
	  return (Complaint[])Complaints;
  }
  boolean replyToComplaint(Complaint ComplaintData){
	  //select complaint from list,reply to it and change ComplaintData.compensation;
	  //return true if operation was successful 
	  return false;
}
  Complaint[] getAllComplaints(){
	  Object Complaints = new Object();
	  //send message to database and select all avialable complaints,return the list
	  return (Complaint[])Complaints;
  }

@Override
public int getId() {//complaint id 
	REQUESTS req = RequestController.REQUESTS.GET_ID_FOR_NEW_COMPLAINT;
	 DataPackage toSend = new DataPackage(req,null);
	 
	 //TODO : need server response method to get complaint id 
	 return 0;
	 
}

@Override
public Employee getEmployee() {// employee instance 
	// TODO Auto-generated method stub
	return null;
}

@Override
public Client getClient() { // Costumer instance 
	return null;
}

@Override
public ComplaintType getType() { //Complaint Type 
	// TODO Auto-generated method stub
	return null;
}

@Override
public String getTitle() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String getContent() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String getReply() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public float getCompensation() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public java.util.Date getSendDateTime() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public java.util.Date getReplyDateTime() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void setEmployee(Employee value) {
	// TODO Auto-generated method stub
	
}

@Override
public void setReply(String value) {
	// TODO Auto-generated method stub
	
}

@Override
public void setCompensation(float value) {
	// TODO Auto-generated method stub
	
}

@Override
public void setReplyDateTime(java.util.Date value) {
	// TODO Auto-generated method stub
	
}

@Override
public void getResults(Object msg) {
	// TODO Auto-generated method stub
	
}
}
  


