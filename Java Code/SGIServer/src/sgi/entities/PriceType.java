package sgi.entities;

import java.io.Serializable;

public class PriceType implements IPriceType , Serializable {

	// Variables
	private static final long serialVersionUID = 9149656090422400767L;
	private int _id;
	private String _name;
	// End variables
	
	// Constructors
	public PriceType(int id, String name) {
		_id = id;
		_name = name;
	}
	// End constructors
	
	// Methods
	public int getId() { return _id; }
	public String getName() { return _name; }
	// Methods
}
