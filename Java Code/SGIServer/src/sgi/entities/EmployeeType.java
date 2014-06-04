package sgi.entities;

import java.io.Serializable;

public class EmployeeType implements IEmployeeType , Serializable {

	// Variables
	private static final long serialVersionUID = -39969203460773357L;
	private int _id;
	private String _name;
	// End variables
	
	// Constructors
	public EmployeeType(int id, String name) {
		_id = id;
		_name = name;
	}
	// End constructors
	
	// Methods
	public int getId() { return _id; }
	public String getName() { return _name; }
	// End methods
}
