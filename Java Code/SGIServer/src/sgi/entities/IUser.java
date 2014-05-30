package sgi.entities;


public interface IUser {	
	Permission getPermission();
	String getUsername();
	String getPassword();
	void setPermission(Permission value);
	void setUsername(String value);
	void setPassword(String value);
}
