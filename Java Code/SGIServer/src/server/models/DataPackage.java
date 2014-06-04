package server.models;

import java.io.Serializable;

import server.controllers.RequestController.REQUESTS;

public class DataPackage implements Serializable {

	private static final long serialVersionUID = 7149802628338847177L;
	
	private REQUESTS _type;
	private Object _data;

	public DataPackage(REQUESTS type, Object data) {
		_type = type;
		_data = data;
	}
	
	public REQUESTS getRequestType() { return _type; }
	public Object getData() { return _data; }
	public void setData(Object value) { _data = value; }
	
}
