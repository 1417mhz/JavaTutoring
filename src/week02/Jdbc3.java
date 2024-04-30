package week02;

import java.sql.*;

public class Jdbc3 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dbUrl = "jdbc:mysql://localhost:3306/studentdb";
			String dbUser = "test_user";
			String dbPw = "testtest";
			
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
			Statement stmt = conn.createStatement();
			
			String query = "SELECT * FROM student";
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				System.out.println("학번: " + rs.getInt("id"));
				System.out.println("이름: " + rs.getString("name"));
				System.out.println("학년: " + rs.getInt("grade") + "학년");
				System.out.println("학과: " + rs.getString(4));
				System.out.println();
			}
			
			rs.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Jdbc 드라이버 로딩 실패");
			
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}

}
