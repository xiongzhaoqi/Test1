package org.softedu.file.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.softedu.file.bean.FileInfo;
import org.softedu.file.util.DBUtil;
import org.softedu.file.util.PageBean;

public class FileDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null, stmt1 = null;
	ResultSet rs = null, rs1 = null;
	PageBean pageBean = new PageBean();
	public int fileInsert(FileInfo files) {
		int flag = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into fileuploads values(null,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, files.getEid());
			pstmt.setString(2, files.getDepartment());
			pstmt.setString(3, files.getName());
			pstmt.setString(4, files.getPosition());
			pstmt.setString(5, files.getPath());
			pstmt.setString(6, files.getFile_name());
			pstmt.setString(7, files.getContent_type());
			pstmt.setString(8, files.getUploadstime());
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public List fileSelect() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List list = new ArrayList();
		String sql = "select * from fileuploads order by file_id desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FileInfo files = new FileInfo();
				files.setFile_id(rs.getInt("file_id"));
				files.setEid(rs.getInt("eid"));
				files.setDepartment(rs.getString("department"));
				files.setName(rs.getString("name"));
				files.setPath(rs.getString("path"));
				files.setFile_name(rs.getString("file_name"));
				files.setContent_type(rs.getString("content_type"));
				files.setUploadstime(rs.getString("uploadstime"));
				list.add(files);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(rs);
			DBUtil.close(conn);
		}
		return list;
	}

	public void fileDel(int id) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from fileuploads where file_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			@SuppressWarnings("unused")
			int flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	public FileInfo selectByid(int id) {
		FileInfo files = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from fileuploads where file_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				files = new FileInfo();
				files.setFile_id(id);
				files.setEid(rs.getInt("eid"));
				files.setDepartment(rs.getString("department"));
				files.setName(rs.getString("name"));
				files.setPath(rs.getString("path"));
				files.setFile_name(rs.getString("file_name"));
				files.setContent_type(rs.getString("content_type"));
				files.setUploadstime(rs.getString("uploadstime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return files;
	}
	
	@SuppressWarnings("unchecked")
	public List queryAllFileuploads(PageBean pageBean) {
		int pageNum = pageBean.getPageNum(); // 得到每页显示的记录数
		int currPage = pageBean.getCurrPage(); // 得到当前页数
		int start = currPage * pageNum; // 当前页的开始记录
		int end = start + pageNum; // 当前页的结束记录

		List list = new ArrayList();
		conn = DBUtil.getConnection();
		String sql = "select * from fileuploads order by file_id desc";
		String sql1 = "select count(*) from fileuploads";
		try {
			stmt1 = conn.createStatement();
			rs1 = stmt1.executeQuery(sql1);
			while (rs1.next()) {
				PageBean.setRecordNum(rs1.getInt(1));
			}
			FileInfo files = null;

			int rowNum = 1;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if ((rowNum > start) && (rowNum <= end)) {
					files = new FileInfo();
					files.setFile_id(rs.getInt("file_id"));
					files.setEid(rs.getInt("eid"));
					files.setDepartment(rs.getString("department"));
					files.setPosition(rs.getString("position"));
					files.setFile_name(rs.getString("file_name"));
					files.setUploadstime(rs.getString("uploadstime"));
				 list.add(files);
				}
				rowNum++;
			}
			PageBean.setRecordNum(rowNum);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DBUtil.close(conn);
			DBUtil.close(stmt);
			DBUtil.close(rs);
		}
		return list;
	}
//
//	private String dept() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	public List deptSelect(String dept) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	@SuppressWarnings("unchecked")
	public List deptSelect(String dept) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		FileInfo files=null;
		List list=new ArrayList();
		String sql = "select * from fileuploads where department=? order by file_id desc";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dept);
			rs=pstmt.executeQuery();
			while(rs.next()){
				 files=new FileInfo();
				 files.setFile_id(rs.getInt("file_id"));
				 files.setEid(rs.getInt("eid"));
				 files.setDepartment(dept);
				 files.setPosition(rs.getString("position"));
				 files.setFile_name(rs.getString("file_name"));
				 files.setUploadstime(rs.getString("uploadstime"));
				 list.add(files);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt);
			DBUtil.close(rs);
			DBUtil.close(conn);
		}
		return list;
	}
}
