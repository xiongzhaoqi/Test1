package org.softedu.file.util;

import java.sql.*;


public class DBUtil {
	public static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//数据库连接URL
	public static String JDBC_URL = "jdbc:mysql://192.168.33.220:3306/filemanager?useUnicode=true&characterEncoding=utf-8";
	//数据库用户名
	public static String JDBC_USER = "java100";
	//数据库密码
	public static String JDBC_PASS = "123";
	
	
	/**
	 * 获得连接对象
	 */
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			//1.加载驱动类
			Class.forName(JDBC_DRIVER);
			//获得连接对象
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭连接对象
	 */
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭处理语句对象
	 */
	
	public static void close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭预处理语句对象
	 */
	
	public static void close(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭结果集对象
	 */
	
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

