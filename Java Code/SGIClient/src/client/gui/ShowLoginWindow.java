package client.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class ShowLoginWindow extends JPanel
{
	private JPanel inPanel;
	private JLabel userNameLabel;
	private JLabel passwordLabel;
	public JTextField userNameText;
	public JTextField passwordText;
	public JButton button;
	public JLabel errorLabel;
	
	/**
	 * Constructor - login form
	 **/
	public ShowLoginWindow() 
	{
		initialize();
	}

	/**
	 * Initialize the components
	 **/
	public void initialize()
	{
		this.button = new JButton ("Sign in");
		this.userNameLabel = new JLabel("User name:");
		this.passwordLabel = new JLabel("Password:");
		this.userNameText = new JTextField(10);
		this.passwordText = new JTextField(10);
		this.errorLabel = new JLabel ("");
		this.errorLabel.setForeground(Color.RED); 
		inPanel = new JPanel (new GridLayout(3, 2, 1, 1));
		inPanel.add (this.userNameLabel);
		inPanel.add (this.userNameText);
		inPanel.add (this.passwordLabel);
		inPanel.add (this.passwordText);
		inPanel.add (this.button);
		inPanel.add (this.errorLabel);
		this.add (inPanel);	
		this.setVisible(true);
	}

}
