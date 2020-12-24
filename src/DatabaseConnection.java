import java.sql.*;

public class DatabaseConnection {
	protected static Connection initializeDB() throws SQLException, ClassNotFoundException{
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		String dbURL = "jdbc:mysql:// localhost:3306/";
		String dbName = "DBMS_Project";
		String dbUsername = "root";
		String dbPwd = "maverick";
		
		Class.forName(dbDriver);
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPwd);	
		} catch (SQLException e) {
			System.out.println("Couldn't connect to Database");
		}
		
		return con;
		
	}


}
