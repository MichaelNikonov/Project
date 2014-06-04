package server.controllers;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import server.controllers.RequestController.REQUESTS;
import server.database.Database;
import server.gui.ServerGUI;
import server.models.DataPackage;
import sgi.entities.*;

import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ServerController extends AbstractServer {

	private ServerGUI _gui;
	private ConfigurationController _config;
	private RequestController _request;
	private Database _db;
	private int _connectedClients = 0;
	
	public void ShowGUI() {
		_gui.setVisible(true);
	}
	
	public int getNumberOfConnectionsToClients() { return _connectedClients; }
	
	public ServerController(int port, ConfigurationController cc) {
		super(port);
		startLog();
		appendToLog("Server initialize with port " + port);
		_config = cc;
		// Initialize DB object
		_db = new Database(_config.getConfiguration().getHost(),_config.getConfiguration().getDBName(),
				_config.getConfiguration().getSqlUsername(),_config.getConfiguration().getSqlPassword());
		_request = new RequestController(_db);
		_gui = new ServerGUI(new ServerGuiActionListener());
	}

	protected void clientConnected(ConnectionToClient client) {
		appendToLog(client.getName() + " connected and got the id: " + client.getId());
		_connectedClients++;
	}

	synchronized protected void clientDisconnected(ConnectionToClient client) {
		appendToLog(client.getName() + " disconnected");
		_connectedClients--;
	}

	protected void serverStarted() {
		appendToLog("Server started");				
	}

	protected void serverStopped() {
		appendToLog("Server stopped");				
	}

	protected void serverClosed() {
		appendToLog("Server closed");				
	}

	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		DataPackage _msg = (DataPackage)msg;
		appendToLog("Request " + _msg.getRequestType().toString() +  " recived from " + client.getName());
		_request.handleRequest(_msg, client);
	}
	
	private void appendToLog(String logEntry) {
		try {
			Date entryTime = new Date();
		    PrintWriter out = new PrintWriter(
		    		new BufferedWriter(new FileWriter("serverlog.html", true)));
		    out.println("<tr><td>" + entryTime.toString() + 
		    		"</td><td>" + logEntry + "</td></tr>");
		    out.close();
		} catch (IOException e) {}		
	}

	private void startLog() {
		try {
			Date entryTime = new Date();
		    PrintWriter out = new PrintWriter(
		    		new BufferedWriter(new FileWriter("serverlog.html", false)));
		    out.println("<html><head><title>SGI Server Log</title></head><body>");
		    out.println("<h1><center>SGI Server Log - " + entryTime.toString() + 
		    		"</center></h1>");
		    out.println("<table align=\"center\" border=\"1\"><tr><td>" +
		    		"<b>Time stamp</b></td><td><b>Event</b></td></tr>");
		    out.close();
		} catch (IOException e) {}		
	}
	
	// Listeners
	class ServerGuiActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Start server")) {
				try {
					listen();
					_gui.setServerStop();
				} catch (IOException e1) {}
			}
			if (e.getActionCommand().equals("Stop server")) {
				try {
					if (getNumberOfConnectionsToClients() > 0) {
						int ans = JOptionPane.showConfirmDialog(null, 
								"There are connected clients.\n" +
								"Stopping the server will disconnect all clients." +
								"Are you sure?", "SGI Server",JOptionPane.YES_NO_OPTION);
						if (ans==JOptionPane.NO_OPTION) return;
					}
					close();
					_gui.setServerStart();
				} catch (IOException e1) {}
			}
			if (e.getActionCommand().equals("Server configuration")) {
				_config.showConfigurationWindow();
			}
		}	
	}

}


