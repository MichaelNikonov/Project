package Server;

import java.sql.*;
import java.util.ArrayList;

public final class Database {

	private Connection _conn;
	
	private PreparedStatement 
		_getUser, _getUsers, 
		_getClientById, _getClientByUsername, _getClientByName,
		_getEmployeeById, _getEmployeeByUsername, _getEmployeeByPosition, 
		_getLocations, _getImages, _getComplaints, 
		_getClientPurchases, _getClientSearchHistory;
	
	/**
	 * <b>Database constructor</b><br>
	 * Create sql connection object and prepared statements.
	 * @param sqlHost
	 * @param sqlDatabase
	 * @param sqlUser
	 * @param sqlPassword
	 */
	public Database(String sqlHost, String sqlDatabase, String sqlUser, 
			String sqlPassword) {
		try {
			// Register driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Create main connection object
			_conn = DriverManager.getConnection(
					"jdbc:mysql://" + sqlHost + "/" + sqlDatabase,
					sqlUser, sqlPassword);
			
			// Create prepared statements
			
			// User
			_getUser = _conn.prepareStatement(
					"SELECT * FROM users INNER JOIN permissions " +
					"ON users.permission = permissions.id " +
					"WHERE username = ? AND password = ?");
			_getUsers = _conn.prepareStatement(
					"SELECT * FROM users INNER JOIN permissions " +
					"ON users.permission = permissions.id");
			
			// Client
			_getClientById = _conn.prepareStatement(
					"SELECT * FROM clients " +
					"WHERE id = ?");
			
			_getClientByUsername = _conn.prepareStatement(
					"SELECT * FROM clients " +
					"WHERE username = ?");
			
			_getClientByName = _conn.prepareStatement(
					"SELECT * FROM clients " +
					"WHERE first_name = ? OR last_name = ?");
			
			// Employee
			_getEmployeeById = _conn.prepareStatement(
					"SELECT * FROM employees INNER JOIN employee_type " +
					"WHERE employees.id = ?");
			
			_getEmployeeByUsername = _conn.prepareStatement(
					"SELECT * FROM employees INNER JOIN employee_type " +
					"WHERE employees.username = ?");
			
			_getEmployeeByPosition = _conn.prepareStatement(
					"SELECT * FROM employees INNER JOIN employee_type " +
					"WHERE employee_type.name = ?");
			
		} catch (SQLException | InstantiationException | IllegalAccessException 
				| ClassNotFoundException e) {
			_conn = null;
			System.out.println(e.getMessage());
			// handle error
		}
	}
	
	private int getResultSetCount(ResultSet rs) {
		if (rs==null) return 0;
		int rowCount = 0;
		try {
			if (rs.last()) {
				rowCount = rs.getRow();
			  rs.beforeFirst(); 
			}
			return rowCount;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
		
	}
	
	public ArrayList<User> getUsers(String username, String password) {
		try {
			ArrayList<User> res = null;
			ResultSet rs = null;
			if (username.length()!=0 && password.length()!=0) {
				_getUser.setString(1, username);
				_getUser.setString(2, password);
				rs = _getUser.executeQuery();
			} else {
				rs = _getUsers.executeQuery();				
			}
			if (getResultSetCount(rs) > 0) {
				res = new ArrayList<User>();
				while (rs.next()) {
					res.add(
							new User(rs.getString(1), rs.getString(2), 
									new Permission(rs.getInt(3), rs.getString(5))));
				}
			}
			return res;
		} catch (SQLException e) {
			// Handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}
