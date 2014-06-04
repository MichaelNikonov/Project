package sgi.entities;

import java.io.Serializable;


public class User implements IUser , Serializable {
	
	// Variables
	private static final long serialVersionUID = -8638504149886091598L;
	private Permission _permission;
	private String _username;
	private String _password;
	// End variables
	
	// Constructors
	public User(String username, String password, Permission permission) {
		_permission = permission;
		_username = username;
		_password = password;
	}
	// End constructors
	
	// Methods
	public Permission getPermission() { return _permission; }
	public String getUsername() { return _username; }
	public String getPassword() { return _password; }
	public void setPermission(Permission value) { _permission = value; }
	public void setUsername(String value) { _username = value; }
	public void setPassword(String value) { _password = value; }
	// End methods
	
}
