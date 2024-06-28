package connection;

import java.sql.*;

public class MyConnection {
	
	public static final String url = "jdbc:mysql://localhost:3306/qlspdt_yp";
	public static final String username = "root";
	public static final String password = "ngochuyen0527";
	public static Connection con = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Tạo kết nối tới cơ sở dữ liệu
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return con;
	}
}
