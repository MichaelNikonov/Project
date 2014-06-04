package sgi.entities;

import java.io.Serializable;
import java.util.Date;

public class SubscriptionPurchase implements ISubscriptionPurchase , Serializable {
	
	// Variables
	private static final long serialVersionUID = -7307931061319771239L;
	private Subscription _subscription;
	private Client _client;
	private Date _datetime;
	private int _usedimgs;
	private float _price;
	// End variables
	
	// Constructors
	public SubscriptionPurchase(Subscription sub, Client clnt, Date dt,
			int usedimgs, float price) {
		_subscription = sub;
		_client = clnt;
		_datetime = dt;
		_usedimgs = usedimgs;
		_price = price;
	}
	// End constructors
	
	// Methods
	public Subscription getSubscription() { return _subscription; }
	public Client getClient() { return _client; }
	public Date getDateTime() { return _datetime; }
	public int getUsedImages() { return _usedimgs; }
	public float getPrice() { return _price; }
	public void setUsedImages(int value) { _usedimgs = value; }
	// End methods
}
