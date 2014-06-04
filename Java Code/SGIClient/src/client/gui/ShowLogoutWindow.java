package client.gui;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ShowLogoutWindow extends JPanel
{
	private JPanel inPanel;
	private JLabel text;
	private JLabel userName;
	public JButton button;
	
	/**
	 * Constructor - user logged in
	 * @param text the label in the Logout view
	 * @param userName the user name
	 * @param buttonContent the content of the button
	 */
	public ShowLogoutWindow(String text, String userName, String buttonContent) 
	{
		initialize(text, userName, buttonContent);
	}
	
	/**
	 * Initialize the components
	 * @param text the label in the Logout view
	 * @param userName the user name
	 * @param buttonContent the content of the button
	 */
	private void initialize (String text, String userName, String buttonContent)
	{
		this.text = new JLabel (text);
		this.userName = new JLabel (userName);
		this.button = new JButton (buttonContent);
		inPanel = new JPanel (new GridLayout(1, 3, 1, 1));
		inPanel.add (this.text);
		inPanel.add (this.userName);
		inPanel.add (this.button);
		this.add (inPanel);	
		this.setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
