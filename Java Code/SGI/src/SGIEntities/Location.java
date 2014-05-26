package SGIEntities;

public class Location {
 
	private int _id, _x, _y;
	private String _name;
	
	public Location(int id, int x, int y, String name) {
		_id = id;
		_x = x;
		_y = y;
		_name = name;
	}
	
	public int getId() { return _id; }
	public int getX() { return _x; }
	public int getY() { return _y; }
	public String getName() { return _name; }
	
}
