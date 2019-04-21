package com.bjsxt.drp.web.usermgr.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bjsxt.drp.business.usermgr.manager.UserManager;

/**
 * 查询所有用户Action
 *
 */
public class ListUserAction  extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//调用业务逻辑操作
		List userList = UserManager.getInstance().findAllUserList();
		request.setAttribute("userlist", userList);
		
		return mapping.findForward("success");
	}
	
}