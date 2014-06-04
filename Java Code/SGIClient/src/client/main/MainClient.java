package client.main;

import java.io.IOException;

import ocsf.client.*;

public class MainClient extends AbstractClient
{
	private ISGIClient _client;
	private Object _msg;
	
	public MainClient(String host, int port) throws IOException 
	{
	    super(host, port); //Call the superclass constructor
	    openConnection();
	    _msg = null;
	}

	@Override
	protected void handleMessageFromServer(Object msg) 
	{
		if (_client != null)
			_client.getResults (msg);
	}
	
	/**
	   * This method handles all data coming from the UI            
	   *
	   * @param message The message from the UI.    
	   */
	  public void handleMessageFromClientUI(Object message, ISGIClient client)
	  {
	    try
	    {
	    	_client = client;
	    	sendToServer(message);
	    	_client = null;
	    }
	    catch(IOException e)
	    {
	    	System.out.println (e.getMessage());
	      quit();
	    }
	  }
	
	/**
	   * This method terminates the client.
	   */
	  public void quit()
	  {
	    try
	    {
	      closeConnection();
	    }
	    catch(IOException e) {}
	    System.exit(0);
	  }

}
