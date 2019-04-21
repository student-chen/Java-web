package cn.dinner.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.http.HttpRequest;

import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONObject;
import cn.dinner.entity.Users;
import cn.dinner.service.Usersservice;
import cn.dinner.util.Page;
import cn.dinner.util.UserCond;

public class UsersAction {
	// 属性
	private Usersservice usersservice;
	// 分页
	private Integer page;
	private Integer limit;
	private Page pageUtil;
	private JSONObject usersjson;
	// 搜索条件
	private String name;
	private Integer mtype;

	// 登陆条件
	private String logname;
	private String logpass;

	// 用户和Session绑定关系
	 public static final Map<String, HttpSession> user_session = new HashMap<String, HttpSession>();
	// SessionId和用户的绑定关系
	 public static final Map<String, String> sessionId_user = new HashMap<String, String>();

	/**
	 * 登陆用户
	 * 
	 * @throws IOException
	 *  io类异常声明
	 */
	public void Login() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
        //处理用户多端在线
		if(sessionId_user!=null){
			for (String str : sessionId_user.keySet()) {
				String uname = sessionId_user.get(str);
				if(uname.equals(logname)){
					out.print(-1);
					return;
				}
			}
		}
		Users user = usersservice.LoginUser(logname);
		if(user.getUPwd().equals(logpass)){
			//绑定用户与session的关系
			user_session.put(logname, session);
			 //同一个浏览器打开新窗口sessionid也是一样，不同浏览器会有不同的sessionid
			//绑定sessionID与用户的关系
			sessionId_user.put(request.getSession().getId(), logname);
			// 将用户加入session
			session.setAttribute("user", user);
		}
		String jsonstr = JSONObject.fromObject(user).toString();
		out.print(jsonstr);
	}

	/**
	 * 登陆后台主页
	 */
	public String goIndex() {
		return "success";
	}

	/***
	 * 后台退出用户
	 * 
	 * @throws IOException
	 */
	public void loginOut() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if (user_session != null) {
			user_session.remove(logname);
			for (String str : sessionId_user.keySet()) {
				String uname = sessionId_user.get(str);
				if(uname.equals(logname)){
					sessionId_user.remove(str);
				}
			}
		}
		out.print("<script>location.href='../login.jsp'</script>");
	}

	/***
	 * 前台退出用户
	 * 
	 * @throws IOException
	 */
	public void loginQTOut() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if (user_session != null) {
			user_session.remove(logname);
			for (String str : sessionId_user.keySet()) {
				String uname = sessionId_user.get(str);
				if(uname.equals(logname)){
					sessionId_user.remove(str);
				}
			}
		}
		out.print("<script>location.href='login.jsp'</script>");
	}

	/**
	 * 分页形式获取所有员工信息
	 * 
	 * @return
	 */
	public String getAllUsers() {
		UserCond cond = new UserCond();
		if (name != null && !name.equals("")) {
			cond.setName("%" + name + "%");
		}
		if (mtype != null && !mtype.equals("")) {
			cond.setMtype(mtype);
		}
		pageUtil = new Page();
		pageUtil.setPageIndex(page);
		pageUtil.setPageSize(limit);
		List<Users> list = usersservice.getAllUsers(pageUtil, cond);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageUtil.getCount());
		map.put("data", list);
		usersjson = JSONObject.fromObject(map);
		return "success";
	}

	// 根据id获取要修改的对象
	private Integer uid;
	private Users Upuser;

	/**
	 * 获取修改信息
	 * 
	 * @return
	 */
	public String getUserInfo() {
		Upuser = usersservice.getOneuser(uid);
		return "success";
	}

	// 修改/添加条件
	private String loginname;
	private String pwd;
	private Integer role;
	private String uname;
	private String sex;
	private String phone;
	private String idcard;
	private String address;

	/**
	 * 修改用户方法
	 * 
	 * @throws IOException
	 */
	public void UpdateUser() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if (role == 1) {
			out.print("<script>alert('禁止修改为管理员');location.href='getoneUser?uid="
					+ uid + "';</script>");
		} else {
			Users user = new Users(uid, loginname, pwd, uname, sex, phone,
					idcard, address, role);
			int res = usersservice.UpdateUser(user);
			if (res == 1) {
				out.print("<script>alert('修改成功');location.href='yuangong.jsp';</script>");
			} else {
				out.print("<script>alert('修改失败');location.href='getoneUser?uid="
						+ uid + "';</script>");
			}
		}
	}

	/**
	 * 添加用户
	 * 
	 * @return
	 * @throws IOException
	 */
	public void AddUser() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		int flagloginName = usersservice.flagLoginName(loginname);
		if (flagloginName == 0) {
			if (role == 1) {
				out.print(-2);
			} else {
				Users user = new Users(loginname, pwd, uname, sex, phone,
						idcard, address, role);
				int res = usersservice.addUser(user);
				if (res > 0) {
					out.print(1);
				} else {
					out.print(-1);
				}
			}
		} else {
			out.print(-3);
		}
	}

	// 删除员工条件
	private Integer delid;

	/**
	 * 删除员工
	 * 
	 * @return
	 * @throws IOException
	 */
	public void delUser() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		int res = usersservice.delUser(delid);
		if (res > 0) {
			out.print(1);
		} else {
			out.print(-1);
		}
	}

	// 修改登陆用户密码条件
	private String Uppwd;

	/**
	 * 修改登录用户密码
	 * 
	 * @return
	 * @throws IOException
	 */
	public void UpUserPwd() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		int res = usersservice.UpUserPwd(uid, Uppwd);
		if (res > 0) {
			out.print(1);
		} else {
			out.print(-1);
		}
	}

	// 封装
	public Usersservice getUsersservice() {
		return usersservice;
	}

	public void setUsersservice(Usersservice usersservice) {
		this.usersservice = usersservice;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Page getPageUtil() {
		return pageUtil;
	}

	public void setPageUtil(Page pageUtil) {
		this.pageUtil = pageUtil;
	}

	public JSONObject getUsersjson() {
		return usersjson;
	}

	public void setUsersjson(JSONObject usersjson) {
		this.usersjson = usersjson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMtype() {
		return mtype;
	}

	public void setMtype(Integer mtype) {
		this.mtype = mtype;
	}

	public String getLogname() {
		return logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Users getUpuser() {
		return Upuser;
	}

	public void setUpuser(Users upuser) {
		Upuser = upuser;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getDelid() {
		return delid;
	}

	public void setDelid(Integer delid) {
		this.delid = delid;
	}

	public String getUppwd() {
		return Uppwd;
	}

	public void setUppwd(String uppwd) {
		Uppwd = uppwd;
	}
	public static Map<String, HttpSession> getUserSession() {
		return user_session;
	}
	public static Map<String, String> getSessionidUser() {
		return sessionId_user;
	}

	public String getLogpass() {
		return logpass;
	}

	public void setLogpass(String logpass) {
		this.logpass = logpass;
	}
}
