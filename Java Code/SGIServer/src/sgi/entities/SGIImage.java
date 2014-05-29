package sgi.entities;

import java.util.Date;

public class SGIImage implements ISGIImage {

	private int _id;
	private Location _location;
	private Date _datetime;
	
	public SGIImage(int id, Location loc, Date dt) {
		_id = id;
		_location = loc;
		_datetime = dt;
	}
	
	public int getId() { return _id; }
	public Location getLocation() { return _location; }
	public Date getDateTime() { return _datetime; }
	
}