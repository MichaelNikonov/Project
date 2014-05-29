package server.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import sgi.entities.*;


public final class Database {

	private Connection _conn;
	
	private PreparedStatement 
		_getPermissions,
		_getUser, _getUsers, 
		_getClientById, _getClientByUsername, _getClientByName, _getClients,
		_getEmployeeById, _getEmployeeByUsername, _getEmployeeByPosition, _getEmployees, 
		_getLocations, _getImage, _getImages,_searchImages, _getComplaints, 
		_getClientPurchases, _getClientSearchHistory;
	
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
			
			// Permissions, Types...
			_getPermissions = _conn.prepareStatement("SELECT * FROM permissions");
			
			// User
			_getUser = _conn.prepareStatement(
					"SELECT * FROM users INNER JOIN permissions " +
					"ON users.permission = permissions.id " +
					"WHERE username = ? AND password = ?");
			_getUsers = _conn.prepareStatement(
					"SELECT * FROM users INNER JOIN permissions " +
					"ON users.permission = permissions.id");
			
			// Client
			_getClients = _conn.prepareStatement(
					"SELECT * FROM clients");
			
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
			_getEmployees = _conn.prepareStatement(
					"SELECT * FROM employees INNER JOIN employee_type " +
					"ON employees.e_type = employee_type.id");
			
			_getEmployeeById = _conn.prepareStatement(
					"SELECT * FROM employees INNER JOIN employee_type " +
					"ON employees.e_type = employee_type.id " +
					"WHERE employees.id = ?");
			
			_getEmployeeByUsername = _conn.prepareStatement(
					"SELECT * FROM employees INNER JOIN employee_type " +
					"ON employees.e_type = employee_type.id " +
					"WHERE employees.username = ?");
			
			_getEmployeeByPosition = _conn.prepareStatement(
					"SELECT * FROM employees INNER JOIN employee_type " +
					"ON employees.e_type = employee_type.id " +
					"WHERE employee_type.name = ?");
			
			// Locations
			_getLocations = _conn.prepareStatement(
					"SELECT * FROM locations");
			
			// Images
			_getImage = _conn.prepareStatement(
					"SELECT * FROM images INNER JOIN locations " +
					"ON images.location = locations.id " +
					"WHERE id = ?");
			
			_getImages = _conn.prepareStatement(
					"SELECT * FROM images INNER JOIN locations " +
					"ON images.location = locations.id");
			
			_searchImages = _conn.prepareStatement(
					"SELECT * FROM images INNER JOIN locations " +
					"ON images.location = locations.id " +
					"WHERE locations.name = ? OR timedate = ?");
			
			// Complaints
			_getComplaints = _conn.prepareStatement(
					"SELECT * FROM complaints INNER JOIN complaint_type " +
					"ON complaints.c_type = complaint_type.id");
			
			
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
	
	private String sqlDateTimeToJavaDate(String sqlvalue) {
		String res = sqlvalue.replace("-", "/");
		res = res.substring(0, res.length()-3);
		return res;
	}
	
	private String javaDateToSqlDateTime(Date jvalue) {
		String temp = jvalue.toString();
		String year = temp.substring(24,28);
		String time = temp.substring(11,19);
		String day = temp.substring(8,10);
		String month = "01";
		if (temp.substring(4,7).equals("Jan")) month = "01";
		if (temp.substring(4,7).equals("Feb")) month = "02";
		if (temp.substring(4,7).equals("Mar")) month = "03";
		if (temp.substring(4,7).equals("Apr")) month = "04";
		if (temp.substring(4,7).equals("May")) month = "05";
		if (temp.substring(4,7).equals("Jun")) month = "06";
		if (temp.substring(4,7).equals("Jul")) month = "07";
		if (temp.substring(4,7).equals("Aug")) month = "08";
		if (temp.substring(4,7).equals("Sep")) month = "09";
		if (temp.substring(4,7).equals("Oct")) month = "10";
		if (temp.substring(4,7).equals("Nov")) month = "11";
		if (temp.substring(4,7).equals("Dec")) month = "12";
		return (year + "-" + month + "-" + day + " " + time); 
	}
	
	public ArrayList<User> getUsers() {
		try {
			ArrayList<User> res = null;
			ResultSet rs = null;
			rs = _getUsers.executeQuery();				
			if (getResultSetCount(rs) > 0) {
				res = new ArrayList<User>();
				while (rs.next()) {
					res.add(
							new User(rs.getString(1), rs.getString(2), 
									new Permission(rs.getInt(3), 
											rs.getString(5))));
				}
			}
			return res;
		} catch (SQLException e) {
			// Handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

	public User getUser(String username, String password) {
		try {
			User res = null;
			ResultSet rs = null;
			_getUser.setString(1, username);
			_getUser.setString(2, password);
			rs = _getUser.executeQuery();
			if (getResultSetCount(rs) > 0) {
				rs.next();
				res = new User(rs.getString(1), rs.getString(2), 
									new Permission(rs.getInt(3), 
											rs.getString(5)));
			}
			return res;
		} catch (SQLException e) {
			// Handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Client getClient(String username) {
		try {
			Client res = null;
			ResultSet rs = null;
			_getClientByUsername.setString(1, username);
			rs = _getClientByUsername.executeQuery();
			if (getResultSetCount(rs) > 0) {
				rs.next();
				res = new Client(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6));
			}
			return res;
		} catch (SQLException e) {
			// Handle exception
			System.out.println(e.getMessage());
			return null;
		}		
	}

	public Client getClient(int id) {
		try {
			Client res = null;
			ResultSet rs = null;
			_getClientById.setInt(1, id);
			rs = _getClientById.executeQuery();
			if (getResultSetCount(rs) > 0) {
				rs.next();
				res = new Client(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6));
			}
			return res;
		} catch (SQLException e) {
			// Handle exception
			System.out.println(e.getMessage());
			return null;
		}		
	}

	public ArrayList<Client> getClients(String firstName, String lastName) {
		try {
			ArrayList<Client> res = null;
			ResultSet rs = null;
			_getClientByName.setString(1, firstName);
			_getClientByName.setString(2, lastName);
			rs = _getClientByName.executeQuery();				
			if (getResultSetCount(rs) > 0) {
				res = new ArrayList<Client>();
				while (rs.next()) {
					res.add(
						new Client(rs.getInt(1), rs.getString(2), rs.getString(3), 
							rs.getString(4), rs.getString(5), rs.getString(6)));				}
			}
			return res;
		} catch (SQLException e) {
			// Handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ArrayList<Client> getClients() {
		try {
			ArrayList<Client> res = null;
			ResultSet rs = null;
			rs = _getClients.executeQuery();				
			if (getResultSetCount(rs) > 0) {
				res = new ArrayList<Client>();
				while (rs.next()) {
					res.add(
						new Client(rs.getInt(1), rs.getString(2), rs.getString(3), 
							rs.getString(4), rs.getString(5), rs.getString(6)));				}
			}
			return res;
		} catch (SQLException e) {
			// Handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ArrayList<Permission> getPermissions() {
		try {
			ArrayList<Permission> res = null;
			ResultSet rs = null;
			rs = _getPermissions.executeQuery();				
			if (getResultSetCount(rs) > 0) {
				res = new ArrayList<Permission>();
				while (rs.next()) {
					res.add(new Permission(rs.getInt(1), rs.getString(2)));
				}
			}
			return res;
		} catch (SQLException e) {
			// Handle exception
			System.out.println(e.getMessage());
			return null;
		}			
	}

	public Employee getEmployee(int id) {
		try {
			Employee res = null;
			ResultSet rs = null;
			_getEmployeeById.setInt(1, id);
			rs = _getEmployeeById.executeQuery();
			if (getResultSetCount(rs) > 0) {
				rs.next();
				res = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6),
						new EmployeeType(rs.getInt(7),rs.getString(10)), rs.getString(8));
			}
			return res;
		} catch (SQLException e) {
			// Handle exception
			System.out.println(e.getMessage());
			return null;
		}		
	}

	public Employee getEmployee(String username) {
		try {
			Employee res = null;
			ResultSet rs = null;
			_getEmployeeByUsername.setString(1, username);
			rs = _getEmployeeByUsername.executeQuery();
			if (getResultSetCount(rs) > 0) {
				rs.next();
				res = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6),
						new EmployeeType(rs.getInt(7),rs.getString(10)), rs.getString(8));
			}
			return res;
		} catch (SQLException e) {
			// Handle exception
			System.out.println(e.getMessage());
			return null;
		}		
	}

	public ArrayList<Employee> getEmployees() {
		try {
			ArrayList<Employee> res = null;
			ResultSet rs = null;
			rs = _getEmployees.executeQuery();				
			if (getResultSetCount(rs) > 0) {
				res = new ArrayList<Employee>();
				while (rs.next()) {
					res.add(new Employee(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5), 
							rs.getString(6), new EmployeeType(rs.getInt(7),
							rs.getString(10)), rs.getString(8)));
				}
			}
			return res;
		} catch (SQLException e) {
			// Handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ArrayList<Employee> getEmployees(String pos) {
		try {
			ArrayList<Employee> res = null;
			ResultSet rs = null;
			_getEmployeeByPosition.setString(1, pos);
			rs = _getEmployeeByPosition.executeQuery();				
			if (getResultSetCount(rs) > 0) {
				res = new ArrayList<Employee>();
				while (rs.next()) {
					res.add(new Employee(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5), 
							rs.getString(6), new EmployeeType(rs.getInt(7),
							rs.getString(10)), rs.getString(8)));
				}
			}
			return res;
		} catch (SQLException e) {
			// Handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ArrayList<Location> getLocations() {
		try {
			ArrayList<Location> res = null;
			ResultSet rs = null;
			rs = _getLocations.executeQuery();				
			if (getResultSetCount(rs) > 0) {
				res = new ArrayList<Location>();
				while (rs.next()) {
					res.add(new Location(rs.getInt(1), rs.getInt(2),
							rs.getInt(3), rs.getString(4)));
				}
			}
			return res;
		} catch (SQLException e) {
			// Handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

	public SGIImage getImage(int id) {
		try {
			SGIImage res = null;
			ResultSet rs = null;
			_getImage.setInt(1, id);
			rs = _getImage.executeQuery();				
			if (getResultSetCount(rs) > 0) {
				res = new SGIImage(rs.getInt(1), new Location(rs.getInt(4), 
							rs.getInt(5), rs.getInt(6), rs.getString(7)), 
							new Date(sqlDateTimeToJavaDate(rs.getString(3))));
			}
			return res;
		} catch (SQLException e) {
			// Handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ArrayList<SGIImage> getImages() {
		try {
			ArrayList<SGIImage> res = null;
			ResultSet rs = null;
			rs = _getImages.executeQuery();				
			if (getResultSetCount(rs) > 0) {
				res = new ArrayList<SGIImage>();
				while (rs.next()) {
					res.add(
						new SGIImage(rs.getInt(1), new Location(rs.getInt(4), 
							rs.getInt(5), rs.getInt(6), rs.getString(7)), 
							new Date(sqlDateTimeToJavaDate(rs.getString(3)))));
				}
			}
			return res;
		} catch (SQLException e) {
			// Handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ArrayList<SGIImage> getImages(String loc, Date dt) {
		try {
			ArrayList<SGIImage> res = null;
			ResultSet rs = null;
			_searchImages.setString(1, loc);
			_searchImages.setString(2, javaDateToSqlDateTime(dt));
			rs = _searchImages.executeQuery();				
			if (getResultSetCount(rs) > 0) {
				res = new ArrayList<SGIImage>();
				while (rs.next()) {
					res.add(
						new SGIImage(rs.getInt(1), new Location(rs.getInt(4), 
							rs.getInt(5), rs.getInt(6), rs.getString(7)), 
							new Date(sqlDateTimeToJavaDate(rs.getString(3)))));
				}
			}
			return res;
		} catch (SQLException e) {
			// Handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ArrayList<Complaint> getComplaints() {
		try {
			ArrayList<Complaint> res = null;
			ResultSet rs = null;
			rs = _getImages.executeQuery();				
			if (getResultSetCount(rs) > 0) {
				res = new ArrayList<Complaint>();
				while (rs.next()) {
					System.out.println(rs.getInt(4));
					res.add(
						new Complaint(rs.getInt(1),
								(rs.getInt(2)!=0 ? getEmployee(rs.getInt(2)) : null),
								(rs.getInt(3)!=0 ? getClient(rs.getInt(3)) : null),
								new ComplaintType(rs.getInt(4),"a"),
								rs.getString(5),rs.getString(6),rs.getString(7),
								rs.getFloat(8),
								new Date(sqlDateTimeToJavaDate(rs.getString(9))),
								new Date(sqlDateTimeToJavaDate(rs.getString(10)))));
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
