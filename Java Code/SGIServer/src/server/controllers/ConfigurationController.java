package server.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import server.models.ServerConfiguration;

public class ConfigurationController {

	private ServerConfiguration _config;
	private final String CONFIG_FILE = "configuration.xml";
	
	public ConfigurationController() {
		File f = new File(CONFIG_FILE);
		if (!f.exists()) return;
		XMLReader xml = new XMLReader(CONFIG_FILE);
		_config = new ServerConfiguration();
		if (!xml.getValue("port").isEmpty())
			_config.setPort(Integer.parseInt(xml.getValue("port")));
	}
	
	public void saveConfiguration() {
		try {
			PrintWriter out = new PrintWriter(CONFIG_FILE);
			out.print(_config.toXMLFileContent());
			out.close();
		} catch (Exception e) {
			System.out.println("ConfigurationController: " + e.getMessage());
		}
	}
}
