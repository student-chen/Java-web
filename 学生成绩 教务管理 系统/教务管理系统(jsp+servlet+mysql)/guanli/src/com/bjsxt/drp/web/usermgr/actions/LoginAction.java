/**
 * 
 */
package com.bjsxt.drp.web.usermgr.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bjsxt.drp.business.usermgr.manager.UserManager;
import com.bjsxt.drp.business.usermgr.model.User;
import com.bjsxt.drp.web.usermgr.forms.UserActionForm;
import com.bjsxt.drp.business.usermgr.manager.UserManager;
import com.bjsxt.drp.business.usermgr.model.User;
/**
 * @author cash
 *
 */
public class LoginAction extends Action {

	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) throws Exception {
		 UserActionForm uaf=(UserActionForm)form;
		 
		 String userId=uaf.getUserId();
		 String password=uaf.getPassword();
		 
		 List userlist = UserManager.getInstance().findAllUserList();
		 User user=null;
		 boolean tag=false;
		 for(int i=0;i<userlist.size();i++){
			 user=(User)userlist.get(i);
			if( user.getUserId().equals(userId) && user.getPassword().equals(password)){
				tag=true;
			}
		 }
		 if(tag){
			 req.getSession().setAttribute("username", userId);
			 return  mapping.findForward("success");
		 }else{
			 req.getSession().setAttribute("username", userId);
			 return mapping.findForward("error");
		 }
		 
	}
	

}
