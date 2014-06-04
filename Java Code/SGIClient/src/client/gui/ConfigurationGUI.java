package client.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfigurationGUI extends JPanel
{
	public JTextField host;
	public JTextField port;
	public JButton save;
	private String _host;
	private int _port;
	public JLabel error;
	
	public ConfigurationGUI(String host, int port)
	{
		initialize(host, String.valueOf(port));
	}
	
	/**
	 * initialize UI components
	 */
	private void initialize(String hostStr, String portNum)
	{
		JPanel inPanel = new JPanel(new GridLayout(3, 2, 1, 1));
		
		inPanel.add(new JLabel("Host: "));
		host = new JTextField (hostStr);
		inPanel.add(host);
		inPanel.add(new JLabel("Port: "));
		port = new JTextField (portNum);
		inPanel.add(port);
		save = new JButton ("Save Changes");
		inPanel.add(save);
		error = new JLabel ("");
		error.setForeground(Color.RED); 
		inPanel.add(error);
		
		this.add(inPanel);
		this.setVisible(true);
	}
}
