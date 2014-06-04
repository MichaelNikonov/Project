package sgi.entities;

import java.io.Serializable;

public class Employee implements IEmployee , Serializable {

	// Variables
	private static final long serialVersionUID = -7034204849504064940L;
	private int _id;
	private String _firstName, _lastName, _phone, _email, _number, _username;
	private EmployeeType _type;
	// End variables
	
	// Constructors
	public Employee(int id, String firstName, String lastName, String phone, 
			String email,String number, EmployeeType type, String username) {
		_id = id;
		_firstName = firstName;
		_lastName = lastName;
		_phone = phone;
		_email = email;
		_number = number;
		_username = username;
		_type = type;
	}
	// End constructors
	
	// Methods
	public int getId() { return _id; }
	public String getFirstName() { return _firstName; }
	public String getLastName() { return _lastName; }
	public String getPhone() { return _phone; }
	public String getEmail() { return _email; }
	public String getNumber() { return _number; }
	public EmployeeType getType() { return _type; }
	public String getUsername() { return _username; }
	// End methods
}
