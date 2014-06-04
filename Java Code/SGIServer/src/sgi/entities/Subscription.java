package sgi.entities;

import java.io.Serializable;

public class Subscription implements ISubscription , Serializable {

	// Variables
	private static final long serialVersionUID = 6117965227807088814L;
	private int _id;
	private boolean _active;
	private SubscriptionType _type;
	private LayerType _layertype;
	private int _imgs;
	// End variables
	
	// Constructors
	public Subscription(int id, SubscriptionType type, LayerType lt, int imgs,boolean active) {
		_id = id;
		_type = type;
		_layertype = lt;
		_imgs = imgs;
		_active = active;
	}
	// End constructors
	
	// Methods
	public int getId() { return _id; }
	public SubscriptionType getType() { return _type; }
	public LayerType getLayerType() { return _layertype; }
	public int getImageAmount() { return _imgs; }
	public boolean getActive() { return _active; }
	public void setImageAmount(int value) { _imgs = value; }
	public void setLayerType(LayerType value) { _layertype = value; }
	public void setSubscriptionType(SubscriptionType value) { _type = value; }
	public void setActive(boolean value) { _active = value; }
	// End methods
	
}
