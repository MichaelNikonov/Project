package Server;

import java.util.ArrayList;

public class ServerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Database db = new Database("localhost","sgi","root","root");
		ArrayList<User> users = db.getUsers();
		if (users!=null)
			for (int i=0; i<users.size();i++) {
				System.out.println(
						users.get(i).getPermission().getName() + ", " + 
						users.get(i).getUsername() + ", " +
						users.get(i).getPassword());
			}
		else
			System.out.println("No users in the system!");
		
		if (db.getUser("dan", "dan")==null)
			System.out.println("User 'avi' does'nt exists");
		else {
			Client avi = db.getClient(2);
			System.out.println(avi.getId() + ", " + avi.getFirstName() + ", " +
					avi.getLastName() + ", " + avi.getPhone() + ", " +
					avi.getEmail() + ", " + avi.getUsername());
		}
			
		ArrayList<Client> clients = db.getClients("Dan","B");
		if (clients!=null)
			for (int i=0; i<clients.size();i++) {
				System.out.println(
						clients.get(i).getId() + ", " + 
						clients.get(i).getFirstName() + ", " +
						clients.get(i).getLastName() + ", " + 
						clients.get(i).getPhone() + ", " +
						clients.get(i).getEmail() + ", " + 
						clients.get(i).getUsername());
			}
		else
			System.out.println("No clients in the system!");
	}

}
