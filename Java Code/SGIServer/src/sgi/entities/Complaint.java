package sgi.entities;

import java.util.Date;

public class Complaint implements IComplaint {

	private int _id;
	private IEmployee _employee;
	private IClient _client;
	private IComplaintType _type;
	private String _title, _content, _reply;
	private float _compensation;
	private Date _senddate, _replydate;

	public Complaint(int id, Client clnt, IComplaintType type,
			String title, String content, Date sentat) {
		_id = id;
		_employee = null;
		_client = clnt;
		_type = type;
		_title = title;
		_content = content;
		_reply = "";
		_compensation = (float)0.0;
		_senddate = sentat;
		_replydate = null;
	}

	public Complaint(int id, IEmployee emp, IClient clnt, IComplaintType type,
			String title, String content, String reply, float comp,
			Date sentat, Date replyat) {
		_id = id;
		_employee = emp;
		_client = clnt;
		_type = type;
		_title = title;
		_content = content;
		_reply = reply;
		_compensation = comp;
		_senddate = sentat;
		_replydate = replyat;
	}
	
	public int getId() { return _id; }
	public IEmployee getEmployee() { return _employee; }
	public IClient getClient() { return _client; }
	public IComplaintType getType() { return _type; }
	public String getTitle() { return _title; }
	public String getContent() { return _content; }
	public String getReply() { return _reply; }
	public float getCompensation() { return _compensation; }
	public Date getSendDateTime() { return _senddate; }
	public Date getReplyDateTime() { return _replydate; }
	
	public void setEmployee(IEmployee value) { _employee = value; }
	public void setReply(String value) { _reply = value; }
	public void setCompensation(float value) { _compensation = value; }
	public void setReplyDateTime(Date value) { _replydate = value; }
	
}
