package org.softedu.file.bean;

public class FileInfo {
	private int file_id;// 鏂囦欢缂栧彿
	private int eid;// 鍛樺伐鍙�
	private String department;// 閮ㄩ棬
	private String name;// 鍛樺伐濮撳悕
	private String position;// 鑱屼綅
	private String path;// 璺緞
	private String file_name;// 鏂囦欢鍚�
	private String content_type;// 鏂囦欢灞炴�
	private String uploadstime;// 涓婁紶鏃堕棿

	public String getUploadstime() {
		return uploadstime;
	}

	public void setUploadstime(String uploadstime) {
		this.uploadstime = uploadstime;
	}

	public int getFile_id() {
		return file_id;
	}

	public void setFile_id(int fileId) {
		file_id = fileId;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String fileName) {
		file_name = fileName;
	}

	public String getContent_type() {
		return content_type;
	}

	public void setContent_type(String contentType) {
		content_type = contentType;
	}
}
