package sgi.entities;

public interface ISubscription {
	int getId();
	SubscriptionType getType();
	LayerType getLayerType();
	int getImageAmount();
	void setImageAmount(int value);
	void setLayerType(LayerType value);
	void setSubscriptionType(SubscriptionType value);
}