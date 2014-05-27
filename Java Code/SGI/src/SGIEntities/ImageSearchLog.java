package SGIEntities;

import java.util.Date;

public class ImageSearchLog implements IImageSearchLog {

	private String _location, _date, _time;
	private IClient _client;
	private Date _datetime;
	private boolean _result;
	
	public ImageSearchLog(String loc, String dt, String tm, IClient clnt, 
			Date dtstamp, boolean res) {
		_location = loc;
		_date = dt;
		_time = tm;
		_client = clnt;
		_datetime = dtstamp;
		_result = res;
	}
	
	public String getLocation() { return _location; }
	public String getDate() { return _date; }
	public String getTime() { return _time; }
	public IClient getClient() { return _client; }
	public Date getDateTime() { return _datetime; }
	public boolean getResult() { return _result; }

}
