package server.main;

import java.util.ArrayList;
import java.util.Date;
import server.database.Database;
import server.models.*;
import sgi.entities.*;

public class ServerMain {

	private static ServerConfiguration _config;
	private static Database _db;
	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// Load configuration
		_config = new ServerConfiguration();
		// Initialize DB object
		_db = new Database(_config.getHost(),_config.getDBName(),
				_config.getSqlUsername(),_config.getSqlPassword());
		
		ArrayList<Location> locations = _db.getLocations();
		SGIImage temp = new SGIImage(0,locations.get(0), new Date());
		if (_db.addImage(temp))
			System.out.println("Image added!");
		else
			System.out.println("Image not added!");
	}

}
