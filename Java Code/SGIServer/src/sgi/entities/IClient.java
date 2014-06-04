package sgi.entities;

public interface IClient {
	int getId();
	String getFirstName();
	String getLastName();
	String getPhone();
	String getEmail();
	User getUser();
	void setFirstName(String value);
	void setLastName(String value);
	void setPhone(String value);
	void setEmail(String value);
	void setUser(User value);
}