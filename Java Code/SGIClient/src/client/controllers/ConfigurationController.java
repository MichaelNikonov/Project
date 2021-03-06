package client.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import client.gui.ConfigurationGUI;
import client.main.MainClient;
import static java.lang.System.out;

public class ConfigurationController 
{
	private MainClient _client;
	private ConfigurationGUI _view;
	
	public ConfigurationController(MainClient client)
	{
		_client = client;
	}
	
	public ConfigurationGUI getView()
	{
		try
		{
			if (_view == null)
			{
				if (_client == null)
					_view = new ConfigurationGUI("localhost", 555);
				else
					_view = new ConfigurationGUI(_client.getHost(), _client.getPort());
				_view.save.addActionListener
				(
						new ActionListener() 
						{
							public void actionPerformed(ActionEvent e) 
							{
								out.println("saved");
								boolean error = false;
								String host = _view.host.getText().trim();
								String port = _view.port.getText().trim();
								if (host.equals(""))
								{
									_view.error.setText("Insert host");
									error = true;
								}
								else if (port.equals(""))
								{
									_view.error.setText("Insert port");
									error = true;
								}
								try
								{
									Integer.parseInt(port);
								}
								catch(Exception e1)
								{
									_view.error.setText("Insert valid port number");
									error = true;
								}
								if (!error)
								{
									try 
									{
										out.println("host" + host);
										out.println("port" + port);
										//_client = new MainClient(host, Integer.parseInt(port));
										_view.setVisible(false);
									} 
									catch (Exception e1) 
									{
										e1.printStackTrace();
									}
								}
							}
						}
					);
			}
			return _view;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	/**
	 * Returns the main client instance
	 * @return
	 */
	public MainClient getMainClient ()
	{
		return _client;
	}
}
