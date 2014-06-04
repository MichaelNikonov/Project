package client.controllers;

import java.util.ArrayList;

import sgi.entities.Client;
import sgi.entities.IClient;

public interface IClientController 
{
	boolean UpdateClient (Client client);
	ArrayList<Client> SearchClients ();
	boolean AddClient (Client client);
	boolean DeleteClient (Client client);
}
