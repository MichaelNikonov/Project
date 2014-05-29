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
		ArrayList<Complaint> employees = db.getComplaints();
		if (employees!=null)
			for (int i=0; i<employees.size();i++) {
				System.out.println(
						employees.get(i).getId() + ", " + 
						(employees.get(i).getEmployee()==null ? "NO EMP" : employees.get(i).getEmployee().getFirstName()) + ", " +
						employees.get(i).getCompensation());
			}
		else
			System.out.println("No Permissions in the system!");
	}

}
