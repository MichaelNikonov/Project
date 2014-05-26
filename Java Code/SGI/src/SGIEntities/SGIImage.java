package SGIEntities;

import java.util.Date;

public class SGIImage {

	private int _id;
	private Location _location;
	private Date _datetime;
	
	public SGIImage(int id, Location loc, Date dt, String filename) {
		_id = id;
		_location = loc;
		_datetime = dt;
	}
	
	public int getId() { return _id; }
	public Location getLocation() { return _location; }
	public Date getDateTime() { return _datetime; }
	
}