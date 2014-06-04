package sgi.entities;

import java.util.Date;
import java.io.Serializable;

public class Purchase implements IPurchase , Serializable {

	// Variables
	private static final long serialVersionUID = 2657248592379832598L;
	private int _id;
	private SGIImage _image;
	private Client _client;
	private PurchaseType _type;
	private float _price;
	private Date _datetime;
	// End variables
	
	// Constructors
	public Purchase(int id, SGIImage img, Client clnt, PurchaseType type, 
			float price, Date dt) {
		_id = id;
		_image = img;
		_client = clnt;
		_type = type;
		_price = price;
		_datetime = dt;
	}
	// End constructors
	
	// Methods
	public int getId() { return _id; }
	public SGIImage getImage() { return _image; }
	public Client getClient() { return _client; }
	public PurchaseType getType() { return _type; }
	public float getPrice() { return _price; }
	public Date getDateTime() { return _datetime; }
	// End methods
}
