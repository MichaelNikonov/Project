package sgi.entities;

import java.io.Serializable;

public class SubscriptionType implements ISubscriptionType, Serializable {

	// Variables
	private static final long serialVersionUID = -351598073165836561L;
	private int _id;
	private String _name;
	// End variables
	
	// Constructors
	public SubscriptionType(int id, String name) {
		_id = id;
		_name = name;
	}
	// End constructors
	
	// Methods
	public int getId() { return _id; }
	public String getName() { return _name; }
	// End methods
	
}
