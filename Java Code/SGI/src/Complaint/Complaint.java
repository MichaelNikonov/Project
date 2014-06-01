package Complaint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Complaint {

	private int id;
	private Date DateAndTime;
	private Date CloseDateAndTime;
	private int ClientID;
	private int EmployeeID;
	private String Title;
	private String Content;
	private String Reply;
	private float Compensation;
	public enum Status {OPEN,PROCESSING,CLOSED};
	private Status currStatus;
	
	Complaint(String Title,String Content,int ClientID){
		//TODO:Database Connection section to get complaint id + date
		//Date date = new Date();
		//this.DateAndTime = date;
		this.Title = Title;
		this.Content = Content;
		this.currStatus = Status.OPEN;
		this.ClientID = ClientID;
		
	}
	
	public int getComplaintID(){
		return this.id;
	}
	public int getClientID(){
		return this.ClientID;
	}
	public int getEmployeeID(){
		if(this.currStatus==Status.OPEN)//The current complaint still has not been addressed by relationShip employee
			return -1;
		  return this.EmployeeID;
	}
	public float getCompenstaion(){
		if(this.currStatus==Status.OPEN)//The current complaint still has not been addressed by relationShip employee
			return -1;
		return this.Compensation;
	}
	public Status getCurrStatus(){
		return this.currStatus;
	}
}
