package sgi.entities;

import java.io.Serializable;

public class ComplaintType implements IComplaintType , Serializable {
	
	// Variables
	private static final long serialVersionUID = 3445555093579270277L;
	private int _id;
	private String _name;
	// End variables
	
	// Constructors
	public ComplaintType(int id, String name) {
		_id = id;
		_name = name;
	}
	// End constructors
	
	// Methods
	public int getId() { return _id; }
	public String getName() { return _name; }
	// End methods
}
