package Complaint;

import java.io.IOException;
import java.sql.Date;
import ocsf.client.*;

public class ComplaintController {

  boolean addNewComplaint(Complaint ComplaintData){
	  //if sending Complaint data was successful return true
	  //else return false
	  ObservableClient conn = new ObservableClient("localhost",4000);
	  try {conn.sendToServer((Object)ComplaintData);}
	  catch(IOException e){}
	  return false;
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
}
  


