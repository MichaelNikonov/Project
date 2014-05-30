package sgi.entities;

import java.util.Date;

public class SubscriptionPurchase implements ISubscriptionPurchase {
	
	private Subscription _subscription;
	private Client _client;
	private Date _datetime;
	private int _usedimgs;
	private float _price;
	
	public SubscriptionPurchase(Subscription sub, Client clnt, Date dt,
			int usedimgs, float price) {
		_subscription = sub;
		_client = clnt;
		_datetime = dt;
		_usedimgs = usedimgs;
		_price = price;
	}
	
	public Subscription getSubscription() { return _subscription; }
	public Client getClient() { return _client; }
	public Date getDateTime() { return _datetime; }
	public int getUsedImages() { return _usedimgs; }
	public float getPrice() { return _price; }
	
	public void setUsedImages(int value) { _usedimgs = value; }
}
