package sgi.entities;

import java.util.Date;

public class SubscriptionPurchase implements ISubscriptionPurchase {
	
	private ISubscription _subscription;
	private IClient _client;
	private Date _datetime;
	private int _usedimgs;
	private float _price;
	
	public SubscriptionPurchase(ISubscription sub, IClient clnt, Date dt,
			int usedimgs, float price) {
		_subscription = sub;
		_client = clnt;
		_datetime = dt;
		_usedimgs = usedimgs;
		_price = price;
	}
	
	public ISubscription getSubscription() { return _subscription; }
	public IClient getClient() { return _client; }
	public Date getDateTime() { return _datetime; }
	public int getUsedImages() { return _usedimgs; }
	public float getPrice() { return _price; }
	
	public void setUsedImages(int value) { _usedimgs = value; }
}
