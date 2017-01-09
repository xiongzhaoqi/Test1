package org.softedu.file.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.softedu.file.bean.Employe;
import org.softedu.file.util.EmployeConn;


public class EmployeDao {
private String sql=null;
public List<Employe> sel(String department){
	sql="select * from users where department=?";
	Connection conn=EmployeConn.getConn();
	PreparedStatement ps;
	List<Employe> list=new ArrayList<Employe>();
	try {
		ps=conn.prepareStatement(sql);
		ps.setString(1,department);
		ResultSet rs=ps.executeQuery();
		while (rs.next()){
			Employe em=new Employe();
			em.setEid(rs.getInt("eid"));
			em.setName(rs.getString("name"));
			em.setSex(rs.getString("sex"));
			em.setDepartment(rs.getString("department"));
			em.setPosition(rs.getString("position"));
			em.setEmployedtime(rs.getString("employedtime"));
			em.setTelphone(rs.getString("telphone"));
			em.setPassword(rs.getString("password"));
			list.add(em);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
public boolean login(int id,String password){
	boolean log=false;
	sql="select * from users where eid=? && password=?";
	Connection conn=EmployeConn.getConn();
	PreparedStatement ps;
	try {
		ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		while (rs.next()){
		log=true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return log;
	
}
public List<Employe> sel(int id){
	sql="select * from users where eid=?";
	Connection conn=EmployeConn.getConn();
	PreparedStatement ps;
	List<Employe> list=new ArrayList<Employe>();
	try {
		ps=conn.prepareStatement(sql);
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while (rs.next()){
			Employe em=new Employe();
			em.setEid(id);
			em.setName(rs.getString("name"));
			em.setSex(rs.getString("sex"));
			em.setDepartment(rs.getString("department"));
			em.setPosition(rs.getString("position"));
			em.setEmployedtime(rs.getString("employedtime"));
			em.setTelphone(rs.getString("telphone"));
			em.setPassword(rs.getString("password"));
			list.add(em);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
}
