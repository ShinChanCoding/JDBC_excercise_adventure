package dev.exercise.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// DB와 관련된 공통 처리 코드들을 별도의 유틸 클래스로 분리
// ex. 데이터 베이스 설정, 연결 등
public class DButil {
	static final String DB_URL = "jdbc:mysql://localhost:3306/"; // DB 서버 접근용 URL
	static final String DATABASE_NAME = "testdb"; // 접속할 데이터베이스 이름
	// CREATE DATABASE testdb; 했을 때 DATABASE 이름
	static final String USER = "root"; // 접속하는 사용자 계정
	static final String PASSWORD = "1234";
	
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}