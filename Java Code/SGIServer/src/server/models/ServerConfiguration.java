package server.models;

public class ServerConfiguration {

	int _port = 5555;
	int _maxUnusedConnectionTime = 10;
	int _complaintReplyDeadline = 1;
	boolean _logoffUnUsedConnections = true;
	
	public ServerConfiguration() {}
	
	public ServerConfiguration(int port, int maxUnusedTime, boolean logoffUnused,
			int complaintReplyDeadline) {
		_port = port;
		_maxUnusedConnectionTime = maxUnusedTime;
		_logoffUnUsedConnections = logoffUnused;
		_complaintReplyDeadline = complaintReplyDeadline;
	}
	
	public int getPort() { return _port; }
	public int getMaxUnusedConnectionTime() { return _complaintReplyDeadline; }
	public int getComplaintReplyDeadline() { return _maxUnusedConnectionTime; }
	public boolean getLogoffUnusedConnections() { return _logoffUnUsedConnections; }
	
	public void setPort(int value) { _port = value; }
	public void setComplaintReplyDeadline(int value) { _complaintReplyDeadline = value; }
	public void setMaxUnusedConnectionTime(int value) { _maxUnusedConnectionTime = value; }
	public void setLogoffUnusedConnections(boolean value) { _logoffUnUsedConnections = value; }
}
