package sgi.entities;

public class ComplaintType implements IComplaintType {

	private int _id;
	private String _name;
	
	public ComplaintType(int id, String name) {
		_id = id;
		_name = name;
	}
	
	public int getId() { return _id; }
	public String getName() { return _name; }

}
