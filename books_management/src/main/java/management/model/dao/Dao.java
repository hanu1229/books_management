package management.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.Getter;

public class Dao {
	protected Connection conn;
	private String url = "jdbc:mysql://localhost:3306/books_management";
	private String user = "root";
	private String pwd = "1234";
	
	// singleton start
	@Getter
	private static Dao instance = new Dao();
	protected Dao() {
		try {			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pwd);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
	// singleton end
	
	
	
}
