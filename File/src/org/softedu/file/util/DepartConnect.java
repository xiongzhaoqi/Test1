package org.softedu.file.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DepartConnect {
public static Connection conn=null;
public static Connection getConn(){
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://192.168.33.220/filemanager", "java100","123");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return conn;
}
public static void ConnectClose(Connection conn){
	if (conn!=null){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
