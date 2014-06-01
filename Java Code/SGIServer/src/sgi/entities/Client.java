package sgi.entities;

public class Client implements IClient {

	private int _id;
	private String _firstName, _lastName, _phone, _email, _username;
	
	public Client(int id, String firstName, String lastName, String phone, 
			String email, String username) {
		_id = id;
		_firstName = firstName;
		_lastName = lastName;
		_phone = phone;
		_email = email;
		_username = username;
	}
	
	public int getId() { return _id; }
	public String getFirstName() { return _firstName; }
	public String getLastName() { return _lastName; }
	public String getPhone() { return _phone; }
	public String getEmail() { return _email; }
	public String getUsername() { return _username; }
	
}