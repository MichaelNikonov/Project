package client.controllers;

public interface IUserController 
{
	boolean LogIn (String userName, String password);
	boolean LogOut ();
}
