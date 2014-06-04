package sgi.entities;

import java.io.Serializable;

public class Permission implements IPermission , Serializable {

	// Variables
	private static final long serialVersionUID = 359385049596126852L;
	private int _id;
	private String _name;
	// End variables
	
	// Constructors
	public Permission(int id, String name) {
		_id = id;
		_name = name;
	}
	// End constructors
	
	// Methods
	public int getId() { return _id; }
	public String getName() { return _name; }
	// End methods
}
