package week02;

import java.sql.*;

public class Jdbc1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dbUrl = "jdbc:mysql://localhost:3306/studentdb";
			String dbUser = "test_user";
			String dbPw = "testtest";
			
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
			System.out.println("DB 연결 성공!");
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Jdbc 드라이버 로딩 실패");
			
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}

}
