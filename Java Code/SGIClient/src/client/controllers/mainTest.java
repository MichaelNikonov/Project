package client.controllers;

import javax.swing.JFrame;

import client.gui.mainGui;
import client.main.MainClient;

public class mainTest 
{

	public static void main (String args[])
	{
		mainGui gui = new mainGui();
		gui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		gui.setSize( 250,250 ); // set frame size
		gui.setVisible( true ); // display frame
	}
}
