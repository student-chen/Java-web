package com.bjsxt.drp.web.usermgr.actions;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bjsxt.drp.web.usermgr.forms.UploadActionForm;
import com.bjsxt.drp.business.usermgr.manager.FileManager;

public class DelFileAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) throws Exception {
		UploadActionForm uaf=(UploadActionForm)form;
	    
		String[] uploadList=uaf.getSelectFlag();


		FileManager.getInstance().deleteUsers(uploadList);
		
		return mapping.findForward("success");
	}

}
