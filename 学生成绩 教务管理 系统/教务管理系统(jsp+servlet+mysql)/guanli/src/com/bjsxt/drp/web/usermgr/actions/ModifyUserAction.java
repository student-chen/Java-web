package com.bjsxt.drp.web.usermgr.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bjsxt.drp.business.usermgr.manager.UserManager;
import com.bjsxt.drp.business.usermgr.model.User;
import com.bjsxt.drp.web.usermgr.forms.UserActionForm;

/**
 * 修改用户Action
 *
 */
public class ModifyUserAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取从页面表单中提交过来的值
		UserActionForm uaf = (UserActionForm)form;
		
//		//创建User实体对象，并将ActionForm中的内容设置到User对象中
//		User user = new User();
//		user.setUserId(uaf.getUserId());
//		user.setUserName(uaf.getUserName());
//		user.setPassword(uaf.getPassword());
//		user.setEmail(uaf.getEmail());
//		user.setContactTel(uaf.getContactTel());
//		user.setCreateDate(new Date());
		
		User user = new User();
		BeanUtils.copyProperties(user, uaf);
		user.setCreateDate(new Date());
		
		//调用业务逻辑操作
		UserManager.getInstance().modifyUser(user);
		
		return mapping.findForward("success");
	}
}