package week02;

import java.sql.*;

public class Jdbc4 {

	public static void main(String[] args) throws SQLException {
		Connection conn = DBConn.getDBConn();
		Statement stmt = conn.createStatement();
		ResultSet rs;
		
		// 삽입
		String insertQuery = "INSERT INTO student VALUES(20202222, '김철수', 3, '컴정')";
		stmt.executeUpdate(insertQuery);
		
		// 조회
		String selectQuery1 = "SELECT * FROM student";
		rs = stmt.executeQuery(selectQuery1);
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
			System.out.println(rs.getString(4));
			System.out.println();
		}
		rs.close();
		
		// 갱신
		String updateQuery = "UPDATE student SET name = '손흥민', grade = 1 WHERE id = 20202222";
		stmt.executeUpdate(updateQuery);
		
		// 조회
		String selectQuery2 = "SELECT * FROM student";
		rs = stmt.executeQuery(selectQuery2);
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
			System.out.println(rs.getString(4));
			System.out.println();
		}
		rs.close();
		
		// 삭제
		String deleteQuery = "DELETE FROM student WHERE id = 20202222";
		int result = stmt.executeUpdate(deleteQuery);
		System.out.println("삭제 결과: " + result);
		
		conn.close();
	}

}
