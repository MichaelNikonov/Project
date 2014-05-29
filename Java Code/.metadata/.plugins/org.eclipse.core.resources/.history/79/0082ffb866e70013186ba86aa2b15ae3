package sgi.entities;

import java.util.Date;

public class Purchase implements IPurchase {

	private int _id;
	private SGIImage _image;
	private IClient _client;
	private IPurchaseType _type;
	private float _price;
	private Date _datetime;
	
	public Purchase(int id, SGIImage img, IClient clnt, IPurchaseType type, 
			float price, Date dt) {
		_id = id;
		_image = img;
		_client = clnt;
		_type = type;
		_price = price;
		_datetime = dt;
	}
	
	public int getId() { return _id; }
	public SGIImage getImage() { return _image; }
	public IClient getClient() { return _client; }
	public IPurchaseType getType() { return _type; }
	public float getPrice() { return _price; }
	public Date getDateTime() { return _datetime; }
	
}
