package dev.exercise.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// DB�� ���õ� ���� ó�� �ڵ���� ������ ��ƿ Ŭ������ �и�
// ex. ������ ���̽� ����, ���� ��
public class DButil {
	static final String DB_URL = "jdbc:mysql://localhost:3306/"; // DB ���� ���ٿ� URL
	static final String DATABASE_NAME = "testdb"; // ������ �����ͺ��̽� �̸�
	// CREATE DATABASE testdb; ���� �� DATABASE �̸�
	static final String USER = "root"; // �����ϴ� ����� ����
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