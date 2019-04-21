package action;

import javax.servlet.http.HttpServletRequest;

import models.Admin;
import models.Student;
import models.Teacher;
import service.ILoginUserService;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	private String usertype;
	private String userid;
	private HttpServletRequest request = null;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public ILoginUserService getLoginuserservice() {
		return loginuserservice;
	}

	public void setLoginuserservice(ILoginUserService loginuserservice) {
		this.loginuserservice = loginuserservice;
	}

	private ILoginUserService loginuserservice;

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String execute() {
		if (userid.equals("")) {
			return "fail";
		} else if (usertype.equals("1")) {
			Student student = loginuserservice.studentLogin(userid);
			if (student != null) {
				ActionContext.getContext().getSession().put("student", student);
				ActionContext.getContext().getSession()
						.put("username", student.getStuName());
				return "studentsuccess";
			} else
				return "fail";
		}

		if (usertype.equals("2")) {
			Teacher teacher = loginuserservice.teacherLogin(userid);
			if (teacher != null) {
				ActionContext.getContext().getSession().put("teacher", teacher);
				ActionContext.getContext().getSession()
						.put("username", teacher.getTName());
				return "teachersuccess";
			} else
				return "fail";
		}

		if (usertype.equals("3")) {
			Admin admin = loginuserservice.adminLogin(userid);
			if (admin != null) {
				ActionContext.getContext().getSession().put("admin", admin);
				ActionContext.getContext().getSession()
						.put("username", admin.getAdminName());
				return "adminsuccess";
			} else
				return "fail";
		}
		return "fail";

	}

}
