package org.softedu.file.util;

import java.sql.*;


public class DBUtil {
	public static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//���ݿ�����URL
	public static String JDBC_URL = "jdbc:mysql://192.168.33.220:3306/filemanager?useUnicode=true&characterEncoding=utf-8";
	//���ݿ��û���
	public static String JDBC_USER = "java100";
	//���ݿ�����
	public static String JDBC_PASS = "123";
	
	
	/**
	 * ������Ӷ���
	 */
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			//1.����������
			Class.forName(JDBC_DRIVER);
			//������Ӷ���
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * �ر����Ӷ���
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
	 * �رմ���������
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
	 * �ر�Ԥ����������
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
	 * �رս��������
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

