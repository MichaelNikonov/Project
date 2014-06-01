package server.models;

public class ServerConfiguration {

	int _port = 5555;
	String _host = "localhost";
	String _dbName = "sgi";
	String _sqlUser = "root";
	String _sqlPassword = "root";
	int _maxUnusedConnectionTime = 10;
	int _complaintReplyDeadline = 1;
	boolean _logoffUnUsedConnections = true;
	
	public ServerConfiguration() {}
	
	public ServerConfiguration(int port, String host, String dbName, String sqlUser,
			String sqlPassword, int maxUnusedTime, boolean logoffUnused,
			int complaintReplyDeadline) {
		_port = port;
		_host = host;
		_dbName = dbName;
		_sqlUser = sqlUser;
		_sqlPassword = sqlPassword;
		_maxUnusedConnectionTime = maxUnusedTime;
		_logoffUnUsedConnections = logoffUnused;
		_complaintReplyDeadline = complaintReplyDeadline;
	}
	
	public int getPort() { return _port; }
	public String getHost() { return _host; }
	public String getDBName() { return _dbName; }
	public String getSqlUsername() { return _sqlUser; }
	public String getSqlPassword() { return _sqlPassword; }
	public int getMaxUnusedConnectionTime() { return _complaintReplyDeadline; }
	public int getComplaintReplyDeadline() { return _maxUnusedConnectionTime; }
	public boolean getLogoffUnusedConnections() { return _logoffUnUsedConnections; }
	
	public void setPort(int value) { _port = value; }
	public void setHost(String value) { _host = value; }
	public void setDBName(String value) { _dbName = value; }
	public void setSqlUsername(String value) { _sqlUser = value; }
	public void setSqlPassword(String value) { _sqlPassword = value; }
	public void setComplaintReplyDeadline(int value) { _complaintReplyDeadline = value; }
	public void setMaxUnusedConnectionTime(int value) { _maxUnusedConnectionTime = value; }
	public void setLogoffUnusedConnections(boolean value) { _logoffUnUsedConnections = value; }
	
	public String toXMLFileContent() {
		String xml = "<Configuration>\n";
		xml += "<Port>" + _port + "</Port>\n";
		xml += "<Host>" + _host + "</Host>\n";
		xml += "<DBName>" + _dbName + "</DBName>\n";
		xml += "<SQLUser>" + _sqlUser + "</SQLUser>\n";
		xml += "<SQLPassword>" + _sqlPassword + "</SQLPassword>\n";
		xml += "<ComplaintReplyDeadline>" + _complaintReplyDeadline + "</ComplaintReplyDeadline>\n";
		xml += "<MaxUnusedConnectionTime>" + _maxUnusedConnectionTime + "</MaxUnusedConnectionTime>\n";
		xml += "<LogoffUnusedConnections>" + _logoffUnUsedConnections + "</LogoffUnusedConnections>\n";
		xml += "</Configuration>";
		return xml;
	}
}
