package sgi.entities;

import java.io.Serializable;

public class PurchaseType implements IPurchaseType , Serializable {

	// Variables
	private static final long serialVersionUID = 891420510746620503L;
	private int _id;
	private String _name;
	// End variables
	
	// Constructors
	public PurchaseType(int id, String name) {
		_id = id;
		_name = name;
	}
	// End constructors
	
	// Methods
	public int getId() { return _id; }
	public String getName() { return _name; }
	// End methods
	
}
