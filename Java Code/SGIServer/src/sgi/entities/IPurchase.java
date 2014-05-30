package sgi.entities;

import java.util.Date;

public interface IPurchase {
	int getId();
	SGIImage getImage();
	Client getClient();
	PurchaseType getType();
	float getPrice();
	Date getDateTime();
}