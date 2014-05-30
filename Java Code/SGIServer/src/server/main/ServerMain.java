package server.main;

import java.util.ArrayList;
import java.util.Date;

import server.database.Database;
import sgi.entities.*;


public class ServerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Database db = new Database("localhost","sgi","root","root");
		/*
		ArrayList<User> users = db.getUsers();
		if (users!=null) {
			System.out.println("User 1: " + users.get(0).getUsername());
			if (db.setUserOnline(users.get(0),"127.0.0.1")==1)
				System.out.println("User 1 is online");
			else
				if (db.setUserOnline(users.get(0),"127.0.0.1")==2) {
					System.out.println("User 1 already online!");
					if (db.setUserOffline(users.get(0)))
						System.out.println("User is now offline!");
					else
						System.out.println("Error logging off the user!");
				}
				else
					System.out.println("Error logging in the user!");
		}
		else
			System.out.println("No Permissions in the system!");
		
		ArrayList<User> users = db.getUnusedLoggedUsers(15);
		if (users==null) System.out.println("no users!"); else
		System.out.println(users.size());
		if (db.removeUnusedLoggedUsers(15)) System.out.println("All 15 min users logged off");
		*/
		ArrayList<LayerType> layers = db.getLayerTypes();
		if (layers==null)
			System.out.println("no layers!");
		else
			for (int i = 0; i < layers.size(); i++) {
				System.out.println(layers.get(i).getId() + ", " + layers.get(i).getName());
		}
	}

}
