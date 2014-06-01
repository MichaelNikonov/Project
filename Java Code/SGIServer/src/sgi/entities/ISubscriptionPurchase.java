package sgi.entities;

import java.util.Date;

public interface ISubscriptionPurchase {
	Subscription getSubscription();
	Client getClient();
	Date getDateTime();
	int getUsedImages();
	float getPrice();
	void setUsedImages(int value);
}
