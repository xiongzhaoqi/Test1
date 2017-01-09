package org.softedu.file.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.softedu.file.bean.User;
import org.softedu.file.util.DBUtil;
import org.softedu.file.util.PageBean;

public class UserDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt, stmt1 = null;
	ResultSet rs = null, rs1 = null;
	PageBean pageBean = new PageBean();

	public List queryAllUsers(PageBean pageBean) {
		 int pageNum = pageBean.getPageNum(); // 得到每页显示的记录数
		 int currPage = pageBean.getCurrPage(); // 得到当前页数
		 int start = currPage * pageNum; // 当前页的开始记录
		 int end = start + pageNum; // 当前页的结束记录
		
		List list = new ArrayList();
		conn = DBUtil.getConnection();
		String sql = "select * from users ";
		String sql1 = "select count(*) from users";
		try {
			 stmt1 = conn.createStatement();
			 rs1 = stmt1.executeQuery(sql1);
			 while (rs1.next()) {
			 PageBean.setRecordNum(rs1.getInt(1));
			 }
			User u = null;

			 int rowNum = 1;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
			 if ((rowNum > start) && (rowNum <= end)) {
				u = new User();
				u.setEid(rs.getInt("eid"));
				u.setName(rs.getString("name"));
				u.setSex(rs.getString("sex"));
				u.setPosition(rs.getString("position"));
				u.setEmployedtime(rs.getString("employedtime"));
				u.setTelphone(rs.getString("telphone"));
				u.setDepartment(rs.getString("department"));
				list.add(u);
			}
			rowNum++;
			 }
			 PageBean.setRecordNum(rowNum);

			// int recordNum=Integer.parseInt(PageBean.getRecordNum());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DBUtil.close(conn);
			DBUtil.close(stmt);
			DBUtil.close(rs);
		}
		return list;
	}

	public List queryCaiWuUsers() {
		List list = new ArrayList();
		conn = DBUtil.getConnection();
		String sql = "select * from users where department='caiwubu'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			User u = null;
			while (rs.next()) {
				u = new User();
				u.setEid(rs.getInt("eid"));
				u.setName(rs.getString("name"));
				u.setSex(rs.getString("sex"));
				u.setPosition(rs.getString("position"));
				u.setEmployedtime(rs.getString("employedtime"));
				u.setTelphone(rs.getString("telphone"));
				u.setDepartment(rs.getString("department"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(stmt);
			DBUtil.close(rs);
		}
		return list;
	}

	public List queryQiYeUsers() {
		List list = new ArrayList();
		conn = DBUtil.getConnection();
		String sql = "select * from users where department='qiyebu'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			User u = null;
			while (rs.next()) {
				u = new User();
				u.setEid(rs.getInt("eid"));
				u.setName(rs.getString("name"));
				u.setSex(rs.getString("sex"));
				u.setPosition(rs.getString("position"));
				u.setEmployedtime(rs.getString("employedtime"));
				u.setTelphone(rs.getString("telphone"));
				u.setDepartment(rs.getString("department"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(stmt);
			DBUtil.close(rs);
		}
		return list;
	}

	public List queryShiChangUsers() {
		List list = new ArrayList();
		conn = DBUtil.getConnection();
		String sql = "select * from users where department='shichangbu'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			User u = null;
			while (rs.next()) {
				u = new User();
				u.setEid(rs.getInt("eid"));
				u.setName(rs.getString("name"));
				u.setSex(rs.getString("sex"));
				u.setPosition(rs.getString("position"));
				u.setEmployedtime(rs.getString("employedtime"));
				u.setTelphone(rs.getString("telphone"));
				u.setDepartment(rs.getString("department"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(stmt);
			DBUtil.close(rs);
		}
		return list;
	}

	public List queryXueShuUsers() {

		List list = new ArrayList();
		conn = DBUtil.getConnection();
		String sql = "select * from users where department='xueshubu'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			User u = null;

			while (rs.next()) {

				u = new User();
				u.setEid(rs.getInt("eid"));
				u.setName(rs.getString("name"));
				u.setSex(rs.getString("sex"));
				u.setPosition(rs.getString("position"));
				u.setEmployedtime(rs.getString("employedtime"));
				u.setTelphone(rs.getString("telphone"));
				u.setDepartment(rs.getString("department"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(stmt);
			DBUtil.close(rs);
		}
		return list;

	}

	public User eidSelect(int eid) {
		User user = null;
		conn = DBUtil.getConnection();
		List list = new ArrayList();
		String sql = "select * from users where eid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setEid(eid);
				user.setName(rs.getString("name"));
				user.setDepartment(rs.getString("department"));
				user.setPosition(rs.getString("position"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(rs);
			DBUtil.close(conn);
		}
		return user;

	}

	public boolean changePassword(int id, String newPassword, String oldPassword) {

		@SuppressWarnings("unused")
		User user = null;
		String old = null;
		String sql1 = "select * from users where eid=?";
		String sql = "update users set password=? where eid=?";
		conn = DBUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				old = rs.getString("password");
				// System.out.println(old);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (old.equals(oldPassword)) {
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, newPassword);
				pstmt.setInt(2, id);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtil.close(conn);
				DBUtil.close(pstmt);
			}
			return true;
		} else
			return false;
	}

	public boolean login(int eid, String password) {
		boolean f = false;
		conn = DBUtil.getConnection();
		String sql = "select * from users where eid=? and password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eid);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				f = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		return f;
	}

	public User selAll(int eid, String password) {
		conn = DBUtil.getConnection();
		String sql = "select * from users where eid=? and password=?";
		User user = new User();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eid);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user.setEid(rs.getInt("eid"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setDepartment(rs.getString("department"));
				user.setPosition(rs.getString("position"));
				user.setEmployedtime(rs.getString("employedtime"));
				user.setTelphone(rs.getString("telphone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		return user;
	}

	public void update(int eid, String name, String sex, String department,
			String position, String employedtime, String telphone,
			String password) {
		try {
			Connection con = DBUtil.getConnection();
			String sql = "update users set eid ='" + eid + "',name ='" + name
					+ "',sex ='" + sex + "',department ='" + department
					+ "',position ='" + position + "',employedtime ='"
					+ employedtime + "',telphone ='" + telphone
					+ "',password='" + password + "' where eid='" + eid + "'";
			Statement stmt = con.createStatement();

			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void del(int eid) {
		Connection con = DBUtil.getConnection();
		String sql = "delete from users where eid='" + eid + "'";
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Boolean insert(User user) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into users values(?,?,?,?,?,?,?,?)";
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user.getEid());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getSex());
			pstmt.setString(4, user.getDepartment());
			pstmt.setString(5, user.getPosition());
			pstmt.setString(6, user.getEmployedtime());
			pstmt.setString(7, user.getTelphone());
			pstmt.setString(8, user.getPassword());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;

	}

}
