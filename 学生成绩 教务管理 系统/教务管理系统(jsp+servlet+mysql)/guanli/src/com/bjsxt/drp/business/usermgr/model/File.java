package com.bjsxt.drp.business.usermgr.model;

import java.sql.Date;

public class File {
	
	public String file_name;
	
	public String file_path;
	
	public Date file_date;

	public Date getFile_date() {
		return file_date;
	}

	public void setFile_date(Date file_date) {
		this.file_date = file_date;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	
	
	

}
