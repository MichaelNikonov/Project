package sgi.entities;

public class Subscription implements ISubscription {

	private int _id;
	private ISubscriptionType _type;
	private ILayerType _layertype;
	private int _imgs;
	
	public Subscription(int id, ISubscriptionType type, ILayerType lt, int imgs) {
		_id = id;
		_type = type;
		_layertype = lt;
		_imgs = imgs;
	}
	
	public int getId() { return _id; }
	public ISubscriptionType getType() { return _type; }
	public ILayerType getLayerType() { return _layertype; }
	public int getImageAmount() { return _imgs; }
	
	public void setImageAmount(int value) { _imgs = value; }
	public void setLayerType(ILayerType value) { _layertype = value; }
	public void setSubscriptionType(ISubscriptionType value) { _type = value; }
}
