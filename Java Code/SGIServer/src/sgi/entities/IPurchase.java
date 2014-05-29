package sgi.entities;

import java.util.Date;

public interface IPurchase {
	int getId();
	ISGIImage getImage();
	IClient getClient();
	IPurchaseType getType();
	float getPrice();
	Date getDateTime();
}