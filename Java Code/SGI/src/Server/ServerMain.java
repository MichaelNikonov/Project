package Server;

import java.util.ArrayList;
import java.util.Date;

import SGIEntities.*;

public class ServerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Database db = new Database("localhost","sgi","root","root");
		Date dt = new Date("2014/01/02 06:00:00");
		ArrayList<SGIImage> employees = db.getImages("",dt);
		if (employees!=null)
			for (int i=0; i<employees.size();i++) {
				System.out.println(
						employees.get(i).getId() + ", " + 
						employees.get(i).getLocation().getName() + ", " +
						employees.get(i).getDateTime().toLocaleString());
			}
		else
			System.out.println("No Permissions in the system!");
	}

}
