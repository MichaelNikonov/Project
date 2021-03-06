package server.main;

import server.controllers.*;
import server.database.Database;

public class ServerMain {

	private static ConfigurationController _config;
	private static Database _db;
	private static ServerController _server;
	
	public static void main(String[] args) {
		// Load configuration
		_config = new ConfigurationController();
		System.out.println("PORT: " + _config.getConfiguration().getPort());
		// Initialize server object
		_server = new ServerController(_config.getConfiguration().getPort(), _config);
		
		_server.ShowGUI();
	}

}
