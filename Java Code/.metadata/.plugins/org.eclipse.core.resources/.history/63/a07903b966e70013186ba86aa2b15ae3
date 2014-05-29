package sgi.entities;

import java.util.Date;

public class Price implements IPrice {

	private int _id;
	private IPriceType _type;
	private float _price;
	private Date _datetime;
	private boolean _ceo;
	private boolean _active;
	
	public Price(int id, IPriceType type, float price, Date dt, boolean ceo,
			boolean active) {
		_id = id;
		_type = type;
		_price = price;
		_datetime = dt;
		_ceo = ceo;
		_active = active;
	}
	
	public int getId() { return _id; }
	public IPriceType getType() { return _type; }
	public float getPrice() { return _price; }
	public Date getDateTime() { return _datetime; }
	public boolean getCeoApprove() { return _ceo; }
	public boolean getActive() { return _active; }
	 
	public void setCeoApprove(boolean value) { _ceo = value; }
	public void setActive(boolean value) { _active = value; }
}
