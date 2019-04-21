package com.bjsxt.drp.web.usermgr.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bjsxt.drp.business.usermgr.manager.UserManager;
import com.bjsxt.drp.web.usermgr.forms.UserActionForm;

/**
 * 用户删除Action
 *
 */
public class DelUserAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取从页面表单中提交过来的值
		UserActionForm uaf = (UserActionForm)form;
		
		//取得需要删除的userId的集合
		String[] userIdList = uaf.getSelectFlag();

		//调用业务逻辑操作
		UserManager.getInstance().deleteUsers(userIdList);
		return mapping.findForward("success");
	}
	
}