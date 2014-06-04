package sgi.entities;

import java.io.Serializable;

public class Location implements ILocation , Serializable {
 
	// Variables
	private static final long serialVersionUID = 869142885068811865L;
	private int _id, _x, _y;
	private String _name;
	// End variables
	
	// Constructors
	public Location(int id, int x, int y, String name) {
		_id = id;
		_x = x;
		_y = y;
		_name = name;
	}
	// End constructors
	
	// Methods
	public int getId() { return _id; }
	public int getX() { return _x; }
	public int getY() { return _y; }
	public String getName() { return _name; }
	// End methods
}
