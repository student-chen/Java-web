package com.bjsxt.drp.web.usermgr.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bjsxt.drp.business.usermgr.manager.UserManager;
import com.bjsxt.drp.business.usermgr.model.User;
import com.bjsxt.drp.web.usermgr.forms.UserActionForm;

/**
 * 根据ID查询用户Action
 *
 */
public class FindUserAction  extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取从页面表单中提交过来的值
		UserActionForm uaf = (UserActionForm)form;
		
		String userId = uaf.getUserId();
		
		//调用业务逻辑操作
		User user = UserManager.getInstance().findUserById(userId);
		
		//将user对象从Action传递到JSP页面
		request.setAttribute("user", user);
		
		return mapping.findForward("success");
	}
	
}