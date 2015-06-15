package mybatis.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 封装对sqlite的增删改查操作
 * 
 * @author corny
 * 
 */
public class SqliteOperations {

	Connection conn = null;
	Statement stmt = null;
	
	public void operate(String sql, String... args) {
		conn = DBConnection.getConnection();

		try {
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getLastId(){
		conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		int id = 0;
		
		try {
			stmt = conn.createStatement();
			String sql = "select max(id) from user";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				id = rs.getInt(1);
				System.out.println(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public void createTabel() {
		String sql = "create table User " 
				+ "(ID INT PRIMARY KEY     NOT NULL,"
				+ " NAME           TEXT    NOT NULL, "
				+ " AGE            INT     NOT NULL )";
//				+ " ADDRESS        CHAR(50), " 
//				+ " SALARY         REAL)";
		Connection conn = DBConnection.getConnection();

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insert(String... args) {
		String sql = "INSERT INTO User (ID,NAME,AGE) "
				+ "VALUES ("+args[0]+", 'Paul', 32);";
		operate(sql, args);
		
		try {
			conn.commit();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SqliteOperations oper = new SqliteOperations();
//		oper.createTabel();
//		for(int i=11;i<20;i++){
//			oper.insert(i+"");
//		}
		int id = oper.getLastId();
		System.out.println("id: "+id);
	}
}
