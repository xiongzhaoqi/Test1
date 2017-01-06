package org.softedu.file.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.softedu.file.bean.Depart;
import org.softedu.file.util.DepartConnect;


public class DepartDao {
private String sql;
public List<Depart> sel(String department){
 sql="select * from fileinfo where department=? ";
 Connection conn=DepartConnect.getConn();
 PreparedStatement ps;
 List<Depart> list=new ArrayList<Depart>();
 try {
	ps=conn.prepareStatement(sql);
	ps.setString(1, department);
	ResultSet rs=ps.executeQuery();
	while (rs.next()){
		Depart d=new Depart();
		d.setId(rs.getInt("id"));
		d.setDepartment(rs.getString("department"));
		d.setManager(rs.getString("manager"));
		d.setInfo(rs.getString("info"));
		list.add(d);
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 
	return list;
}

}
