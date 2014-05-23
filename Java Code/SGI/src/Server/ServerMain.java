package Server;

import java.util.ArrayList;

public class ServerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Database db = new Database("localhost","sgi","root","root");
		ArrayList<User> users = db.getUsers("dani", "dani");
		if (users!=null)
			for (int i=0; i<users.size();i++) {
				System.out.println(
						users.get(i).getPermission().getName() + ", " + 
						users.get(i).getUsername() + ", " +
						users.get(i).getPassword());
			}
		else
			System.out.println("No such user");
	}

}
