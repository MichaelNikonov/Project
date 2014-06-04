package sgi.entities;

import java.io.Serializable;

public class Client implements IClient , Serializable {

	// Variables
	private static final long serialVersionUID = -2898543220945600108L;
	private int _id;
	private String _firstName, _lastName, _phone, _email;
	private User _user;
	// End variables
	
	// Constructors
	public Client(int id, String firstName, String lastName, String phone, 
			String email, User usr) {
		_id = id;
		_firstName = firstName;
		_lastName = lastName;
		_phone = phone;
		_email = email;
		_user = usr;
	}
	// End constructors
	
	// Methods
	public int getId() { return _id; }
	public String getFirstName() { return _firstName; }
	public String getLastName() { return _lastName; }
	public String getPhone() { return _phone; }
	public String getEmail() { return _email; }
	public User getUser() { return _user; }
	public void setFirstName(String value) { _firstName = value; }
	public void setLastName(String value) { _lastName = value; }
	public void setPhone(String value) { _phone = value; }
	public void setEmail(String value) { _email = value; }
	public void setUser(User value) { _user = value; }
	// End methods
	
}
