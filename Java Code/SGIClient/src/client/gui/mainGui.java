package client.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import sgi.entities.Permission;
import sgi.entities.User;
import client.controllers.ClientController;
import client.controllers.ConfigurationController;
import client.controllers.UserController;

public class mainGui extends JFrame
{
	/*private	JPanel		topPanel;
	private	JTable		table;
	private	JScrollPane scrollPane;*/
	
	public mainGui ()
	{
		ConfigurationController gui = new ConfigurationController(null);
		this.add (gui.getView());
//		ClientController client = new ClientController(null);
//		ClientsView v = client.getClientsView();
//		this.add(v);
//		Permission s = new  Permission(0, "123");
//		User user = new User ("Yana", "123", s);
//		UserController userC = new UserController(null, user);
//		this.add (userC.getLoginView());
		//this.add (userC.getLogoutView());
		//this.setVisible(true);
		
		/*setTitle( "Simple Table Application" );
		setSize( 300, 200 );
		setBackground( Color.gray );

		// Create a panel to hold all other components
		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		this.add (topPanel);
		//getContentPane().add( topPanel );

		// Create columns names
		String columnNames[] = { "Column 1", "Column 2", "Column 3" };

		// Create some data
		String dataValues[][] =
		{
			{ "12", "234", "67" },
			{ "-123", "43", "853" },
			{ "93", "89.2", "109" },
			{ "279", "9033", "3092" }
		};

		// Create a new table instance
		table = new JTable( dataValues, columnNames );

		// Add the table to a scrolling pane
		scrollPane = new JScrollPane( table );
		topPanel.add( scrollPane, BorderLayout.CENTER );*/
	}
}
