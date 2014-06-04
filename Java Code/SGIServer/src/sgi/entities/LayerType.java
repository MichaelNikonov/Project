package sgi.entities;

import java.io.Serializable;

public class LayerType implements ILayerType , Serializable {

	// Variables
	private static final long serialVersionUID = -8278030291891510972L;
	private int _id;
	private String _name;
	// End variables
	
	// Constructors
	public LayerType(int id, String name) {
		_id = id;
		_name = name;
	}
	// End constructors
	
	// Methods
	public int getId() { return _id; }
	public String getName() { return _name; }
	// End methods
}
