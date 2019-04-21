package com.bjsxt.drp.web.usermgr.actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bjsxt.drp.business.usermgr.manager.FileManager;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ListFileAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) throws Exception {
		List fileList=(List)FileManager.getInstance().findAllUserList();
		
		req.getSession().setAttribute("filelist", fileList);

		return mapping.findForward("success");
		
	}


}
