package sgi.entities;

public class Subscription implements ISubscription {

	private int _id;
	private SubscriptionType _type;
	private LayerType _layertype;
	private int _imgs;
	
	public Subscription(int id, SubscriptionType type, LayerType lt, int imgs) {
		_id = id;
		_type = type;
		_layertype = lt;
		_imgs = imgs;
	}
	
	public int getId() { return _id; }
	public SubscriptionType getType() { return _type; }
	public LayerType getLayerType() { return _layertype; }
	public int getImageAmount() { return _imgs; }
	
	public void setImageAmount(int value) { _imgs = value; }
	public void setLayerType(LayerType value) { _layertype = value; }
	public void setSubscriptionType(SubscriptionType value) { _type = value; }
}
