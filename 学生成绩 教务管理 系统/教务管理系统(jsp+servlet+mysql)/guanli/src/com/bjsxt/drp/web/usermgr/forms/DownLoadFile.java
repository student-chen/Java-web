package com.bjsxt.drp.web.usermgr.forms;

import javax.servlet.http.HttpServletResponse;

public class DownLoadFile {
	HttpServletResponse res;
	String file_name;
	public void setRes(HttpServletResponse res) {
		this.res = res;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
}
