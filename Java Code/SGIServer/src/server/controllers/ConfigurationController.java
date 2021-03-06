package server.controllers;

import java.io.File;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import server.gui.ConfigurationGUI;
import java.awt.event.ActionListener;
import server.models.ServerConfiguration;

public class ConfigurationController {

	// Variables
	private ServerConfiguration _config;
	private ConfigurationGUI _gui;
	private final String CONFIG_FILE = "configuration.xml";
	// End of variables
	
	// Constructors
	/**
	 * Configuration Controller
	 * If configuration file exists (configuration.xml), than the configuration
	 * properties will be loaded from the file, else, there will be initialized
	 * to default values.
	 */
	public ConfigurationController() {
		File f = new File(CONFIG_FILE);
		_config = new ServerConfiguration();
		if (!f.exists()) {
			saveConfiguration();
			return;
		}
		XMLReader xml = new XMLReader(CONFIG_FILE);
		if (!xml.getValue("Port").isEmpty())
			_config.setPort(Integer.parseInt(xml.getValue("Port")));
		if (!xml.getValue("Host").isEmpty())
			_config.setHost(xml.getValue("Host"));
		if (!xml.getValue("DBName").isEmpty())
			_config.setDBName(xml.getValue("DBName"));
		if (!xml.getValue("SQLUser").isEmpty())
			_config.setSqlUsername(xml.getValue("SQLUser"));
		if (!xml.getValue("SQLPassword").isEmpty())
			_config.setSqlPassword(xml.getValue("SQLPassword"));
		if (!xml.getValue("ComplaintReplyDeadline").isEmpty())
			_config.setComplaintReplyDeadline(Integer.parseInt(xml.getValue("ComplaintReplyDeadline")));
		if (!xml.getValue("MaxUnusedConnectionTime").isEmpty())
			_config.setMaxUnusedConnectionTime(Integer.parseInt(xml.getValue("MaxUnusedConnectionTime")));
		if (!xml.getValue("LogoffUnusedConnections").isEmpty())
			_config.setLogoffUnusedConnections(Boolean.parseBoolean(xml.getValue("LogoffUnusedConnections")));
	}
	// End of constructors
	
	// Methods
	/**
	 * Save Configuration
	 * Saves the current configuration to the configuration file (configuration.xml)
	 */
	public void saveConfiguration() {
		try {
			PrintWriter out = new PrintWriter(CONFIG_FILE);
			out.print(_config.toXMLFileContent());
			out.close();
		} catch (Exception e) {
			System.out.println("ConfigurationController: " + e.getMessage());
		}
	}
	
	/**
	 * Show Configuration Window
	 * Loads the current configuration to the configuration window, and display it.
	 */
	public void showConfigurationWindow() {
		_gui = new ConfigurationGUI(_config);
		_gui.addSaveButton(new ConfigurationWindowActionListener());
		_gui.setVisible(true); 
	}
	
	/**
	 * Get Configuration
	 * Get the current configuration object
	 * @return ServerConfiguration object with the current configuration
	 */
	public ServerConfiguration getConfiguration() { return _config; }
	
	/**
	 * Set Configuration
	 * Sets the current configuration
	 * @param value - The configuration object to be set to
	 */
	public void setConfiguration(ServerConfiguration value) { _config = value; }
	// End of methods
	
	// Listeners
	class ConfigurationWindowActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Save configuration")) {
				if (_config.getPort() != _gui.getConfiguration().getPort()) {
					JOptionPane.showMessageDialog(null, 
							"Server port was changed.\n" +
							"Server must be restarted for changes to take " +
							"effect.", "SGI Server",JOptionPane.INFORMATION_MESSAGE);
				}
				_config = _gui.getConfiguration();
				saveConfiguration();
				_gui.dispose();
			}
		}		
	}
	// End of listeners
}
