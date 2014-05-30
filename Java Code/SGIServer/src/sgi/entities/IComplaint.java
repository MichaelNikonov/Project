package sgi.entities;

import java.util.Date;

public interface IComplaint {
	
	int getId();
	Employee getEmployee();
	Client getClient();
	ComplaintType getType();
	String getTitle();
	String getContent();
	String getReply();
	float getCompensation();
	Date getSendDateTime();
	Date getReplyDateTime();
	
	void setEmployee(Employee value);
	void setReply(String value);
	void setCompensation(float value);
	void setReplyDateTime(Date value);
	
}
