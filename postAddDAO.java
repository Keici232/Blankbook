package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.postAdd;


public class postAddDAO {
	
	public static boolean isRunning;

	// Declaring the variables
	static Connection con = null;
	static PreparedStatement stmt = null;
	static ResultSet rs = null;
	static String query = null;

	postAdd post = null;

	public Connection postDB() {

		// variables
		final String dbUrl = "jdbc:mysql://localhost:8889/mediaremake";
		final String dbUsername = "root";
		final String dbPassword = "root";

		try {

			// driver path
			Class.forName("com.mysql.cj.jdbc.Driver");

			// establish the connection to DB
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

			// check connection
			if (con == null) {
				System.out.println("JDBC connection is not established");

			} else {
				System.out.println("Connection Successfully");
			}

		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} catch (Exception ex) {
			// handle the error
			System.out.println("Exception Driver: " + ex);

		}

		return con;

	}

	public ArrayList<postAdd> list() {

		ArrayList<postAdd> postList = new ArrayList<>();

		try {

			// query = "INSERT INTO `addpost`(`post`, `tag`) VALUES (?, ?)";
			query = "SELECT * FROM addpost";
			con = postDB();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();

			while (rs.next()) {
				post = new postAdd();
				if (post != null) {
					post.setaddPost_id(rs.getInt("addPost_id"));
					post.setPost(rs.getString("post"));
					post.setTag(rs.getString("tag"));
					postList.add(post);
				}
			}
			
			rs.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}

		return postList;

	}

	public boolean save(postAdd post) {

		try {

			query = "INSERT INTO `addpost`(`post`, `tag`) VALUES ('" + post.getPost() + "','" + post.getTag() + "')";
			con = postDB();
			stmt = con.prepareStatement(query);
			stmt.executeUpdate();
			//rs.getString(post.getPost() + rs.getString(post.getTag()));
			stmt.close();
			con.close();
			
			
			

		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}

		return false;

	}

	
	public void delete(int id) {
		
		
		try {
			con = postDB();
			query = "DELETE FROM addpost WHERE addPost_id= " + id;
			stmt = con.prepareStatement(query);

			int row = stmt.executeUpdate();
			
			if (row > 0) {
				System.out.println("DELETED");
			}
			
			con.close();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	
}
