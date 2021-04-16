package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.userBean;

public class userDAO {

	// Declaring the variables
	static Connection con = null;
	static PreparedStatement stmt = null;
	static ResultSet rs = null;
	static String query = null;

	public userBean checkLogin(String fullname, String password) {

		// variables
		final String dbUrl = "jdbc:mysql://localhost:8889/loginremake";
		final String dbUsername = "root";
		final String dbPassword = "root";
		userBean user = null;

		try {

			// driver path
			Class.forName("com.mysql.cj.jdbc.Driver");

			// establish the connection to DB
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

//			// check connection
//			if (con == null) {
//				System.out.println("JDBC connection is not established");
//
//			} else {
//				System.out.println("Connection Successfully");
//			}

			// query
			query = "SELECT * FROM user WHERE fullname = ? AND password = ?";

			stmt = con.prepareStatement(query);
			
			stmt.setString(1, fullname);
			stmt.setString(2, password);
			
			rs = stmt.executeQuery();

	
			
			if (rs.next()) {
				user = new userBean();
				user.setFullname(rs.getString("fullname"));
				user.setPassword(password);
			
			}

			con.close();
			
			

		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} catch (Exception ex) {
			// handle the error
			System.out.println("Exception Driver: " + ex);

		}
		return user;
		
		
	}	
}
