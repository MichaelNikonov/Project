package sgi.entities;


public interface IUser {	
	IPermission getPermission();
	String getUsername();
	String getPassword();
	void setPermission(IPermission value);
	void setUsername(String value);
	void setPassword(String value);
}
