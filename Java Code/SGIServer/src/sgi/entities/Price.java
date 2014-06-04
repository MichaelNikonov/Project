package sgi.entities;

import java.util.Date;
import java.io.Serializable;

public class Price implements IPrice , Serializable {

	// Variables
	private static final long serialVersionUID = 7932554269740557345L;
	private int _id;
	private PriceType _type;
	private float _price;
	private Date _datetime;
	private boolean _ceo;
	private boolean _active;
	// End variables
	
	// Constructors
	public Price(int id, PriceType type, float price, Date dt, boolean ceo,
			boolean active) {
		_id = id;
		_type = type;
		_price = price;
		_datetime = dt;
		_ceo = ceo;
		_active = active;
	}
	// End constructors
	
	// Methods
	public int getId() { return _id; }
	public PriceType getType() { return _type; }
	public float getPrice() { return _price; }
	public Date getDateTime() { return _datetime; }
	public boolean getCeoApprove() { return _ceo; }
	public boolean getActive() { return _active; }
	public void setCeoApprove(boolean value) { _ceo = value; }
	public void setActive(boolean value) { _active = value; }
	// End methods
}
