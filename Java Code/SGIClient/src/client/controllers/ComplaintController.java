package client.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import ComplaintsGUI.ComplaintWorkerGUI;
import ComplaintsGUI.ShowAllComplaints;

import client.main.ISGIClient;
import client.main.MainClient;
import server.controllers.RequestController;
import server.controllers.RequestController.REQUESTS;
import server.models.DataPackage;
import sgi.entities.Client;
import sgi.entities.Complaint;
import sgi.entities.ComplaintType;
import sgi.entities.Employee;
import sgi.entities.IComplaint;


public class ComplaintController implements ISGIClient, IComplaint{
	
	
	private ArrayList<Complaint> complaintBuffer=null; //Complaint buffer for multiple received complaints 
	private MainClient clientForSend;
	private ISGIClient iclient;
	private ComplaintWorkerGUI ComplaintWorkerGUI;
	private  ShowAllComplaints allComplaintsList;
	public ComplaintController(MainClient client,ComplaintWorkerGUI parentGUI){
		this.clientForSend =  client;
		iclient = this;
		this.ComplaintWorkerGUI = parentGUI;
		

		
	}
	
 /**
  * Basic sending function to send data to server ,in case of succession returns true,otherwise returns false with exception
  * @param ComplaintData   - Complaint data to be sent to server 
  * @param req - kind of request
  * @throws IOException
  */
 private void sendMessage (Complaint ComplaintData,REQUESTS req ) throws IOException{
	 
	  DataPackage toSend = new DataPackage(req,(Object)ComplaintData);
	  clientForSend.handleMessageFromClientUI((Object)toSend,iclient );
	
 }
/**
 * Simple function that requests the server to add new row in complaint table,once added,server must return the new complaint ID
 * in this case the "data" parameter is null and request is GET_ID_FOR_NEW_COMPLAINT
 *
 * @return - true in case of successful sending,false otherwise.
 
 public boolean addNewComplaint(){ 
	 REQUESTS req = RequestController.REQUESTS.GET_ID_FOR_NEW_COMPLAINT;
	  try {
		  sendMessage(null,req);
		  return true;
	  }
	  catch (IOException e){
		  
		  System.out.println(e.getMessage());
		  return false;
	  }
	 
 }*/
 /**
  * Function,that sends the whole new complaint data that received from GUI.
  * @param ComplaintData - Complaint parameters,including id = 0,date created,title,costumer added..
  * @return - true in case of successful sending ,false-otherwise
  */
  public boolean addNewComplaint(Complaint ComplaintData){
	  REQUESTS req = RequestController.REQUESTS.ADD_COMPLAINT;
	  try {
		  sendMessage(ComplaintData,req);
		  return true;
	  }
	  catch (IOException e){
		  
		  System.out.println(e.getMessage());
		  return false;
	  }
	  
  }  
  
  
  /**
   * Function for creating new table in GUI that contains all current complaints
   */
 public void  getAllComplaints(){
	  REQUESTS req = RequestController.REQUESTS.GET_ALL_COMPLAINTS;
	  try { sendMessage(null,req);
	  while (complaintBuffer==null){} //wait until message from server has not been received.
	  ShowAllComplaints allComplaints = new  ShowAllComplaints(this);//create new empty list 
	  this.allComplaintsList = allComplaints;
	  DefaultTableModel model = (DefaultTableModel)allComplaints.getTblComplaints().getModel();
	  // loop for adding rows to empty table
	  for(int i =0 ;i < complaintBuffer.size();i++){
		  model.addRow(new Object[]{complaintBuffer.get(i).getClient().getId(),
				                    complaintBuffer.get(i).getClient().getUser(),
				                    complaintBuffer.get(i).getTitle(),
				                    complaintBuffer.get(i).getSendDateTime(),
				                    complaintBuffer.get(i).getReplyDateTime(),
				                    complaintBuffer.get(i).getEmployee().getId(),
				                    complaintBuffer.get(i).getEmployee().getFirstName(),
				                    complaintBuffer.get(i).getCompensation()});
	  }
	  allComplaints.setVisible(true);//show All complaint list
	    }
	  catch (IOException e){
		  System.out.println(e.getMessage());
		  complaintBuffer=null;
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


@Override
public int getId() {//get last new added complaint id 
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
/**
 * Function for handling answers from server 
 */
public void getResults(Object msg) {
	DataPackage temp = (DataPackage)msg;
	REQUESTS req  = temp.getRequestType();
	switch(req){
	/**
	 * in those cases server returning an ArrayList of complaints that must be displayed in GUI.
	 */
	case GET_ALL_COMPLAINTS : {complaintBuffer = (ArrayList<Complaint>) temp.getData();break;}
	case GET_UNSEEN_COMPLAINTS : {complaintBuffer = (ArrayList<Complaint>) temp.getData();break;}
	case GET_UNADDRESSED_COMPLAINTS:{complaintBuffer = (ArrayList<Complaint>) temp.getData();break;}
	}
	
}



public ArrayList<Complaint> getComplaitBuffer() {
	return complaintBuffer;
}

public void setComplaintBuffer(ArrayList<Complaint> complaintBuffer) {
	this.complaintBuffer = complaintBuffer;
}

public ComplaintWorkerGUI getComplaintWorkerGUI() {
	return ComplaintWorkerGUI;
}

public ShowAllComplaints getAllComplaintsList() {
	return allComplaintsList;
}

}
  


