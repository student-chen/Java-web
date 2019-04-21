package com.bjsxt.drp.web.usermgr.forms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class UploadActionForm extends ActionForm {

    private String title;
     
    private FormFile myfile;

	private String[] selectFlag;
	
	public FormFile getMyfile() {
		return myfile;
	}

	public void setMyfile(FormFile myfile) {
		this.myfile = myfile;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(String[] selectFlag) {
		this.selectFlag = selectFlag;
	}
     
}
