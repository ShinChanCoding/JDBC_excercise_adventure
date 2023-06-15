package dev.exercise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dev.exercise.model.Adventure;
import dev.todo.util.DBUtil;

public class AdventureDAO {
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	public List<Adventure> findBag() {
		// DB�� �����ϴ� �ڵ� �ۼ�
		final String selectQuery = "SELECT * FROM mybag";
		List<Adventure> items = new ArrayList<>();
		try {
			// DB���� ���� ��ü ����
			// �ʿ��� ���̺귯�� ����: Referenced Libraries/mysql-connector-j-8.0.33.jar
			connection = DBUtil.getConnection();
			statement = connection.createStatement(); // DB���� Query ���� ��ü ����
			resultSet = statement.executeQuery(selectQuery);
			// ResultSet ��ü Ȱ��
			while (resultSet.next()) { // next(): Ŀ���� ���� ������ �̵�
				int id = resultSet.getInt("bag_id");
				String item = resultSet.getString("item");
				int item_weight = resultSet.getInt("item_weight");
				// java.sql.date ��Ű��
				int item_price = resultSet.getInt("item_price");
				Timestamp timestamp = resultSet.getTimestamp("input_time");
				LocalDateTime dueDate = timestamp.toLocalDateTime();
				items.add(new Adventure(id, item, item_weight, item_price, dueDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ڿ� �ݳ�, ����(���� -> ����)
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}
	
	public Adventure findItemById(int ItemId) {
		Adventure item = null;
		ResultSet rs = null;
		// Java7 ���� ��� try-with-resources ����
		// try () �Ұ�ȣ ���ο� �ۼ��� JDBC ��ü���� �ڵ����� �ڿ��� �ݳ���(close()�� ������� �ʾƵ� ��)
		// JDBC ��ü �̿ܿ� �ڿ� �ݳ��� �ʿ��� �ٸ� ��ü�鵵 �����ϰ� ��� ����
		// ����, AutoCloseable �������̽��� ��ӹ��� Ŭ������ ��� ����
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from mybag where bag_id = ?");) {
			statement.setInt(1, ItemId);// ?�� ����(���ε�)�� ���� ����, �������� ����ǥ ������ŭ �ѹ��� ����
			rs = statement.executeQuery();
			rs.next();
			int id = rs.getInt("bag_id");
			String itemname = rs.getString("item");
			int item_weight = rs.getInt("item_weight");
			int item_price = rs.getInt("item_price");
			Timestamp timestamp = rs.getTimestamp("input_time");
            LocalDateTime dueDate = timestamp.toLocalDateTime();
			item = new Adventure(id, itemname, item_weight, item_price, dueDate);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		return item;
	}
	public int saveItem(int id, String item, int item_weight, int item_price) {
	    int success = 0;
	    try (Connection connection = DBUtil.getConnection();
	         PreparedStatement statement = connection.prepareStatement("INSERT INTO mybag (bag_id, item, item_weight, item_price) VALUES (?, ?, ?, ?)")) {
	        statement.setInt(1, id);
	        statement.setString(2, item);
	        statement.setInt(3, item_weight);
	        statement.setInt(4, item_price);
	        success = statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return success;
	}
	public int deleteItem(int id) {
		int rowsAffected = 0;
	    try (Connection connection = DBUtil.getConnection();
	         PreparedStatement statement = connection.prepareStatement("DELETE FROM mybag WHERE bag_id = ?")) {
	    	statement.setInt(1, id);
	       
	        rowsAffected = statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return rowsAffected;
	}
	
}
