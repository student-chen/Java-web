package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import util.DB;
import dao.ILogin;
import entity.Operator;
import entity.Privilege;

public class LoginImpl implements ILogin {
	private PrivilegeImpl1 privilegeImpl = new PrivilegeImpl1();
	private RoleImpl roleImpl = new RoleImpl();
	private List<Privilege> list_privilege;
	private PreparedStatement pst;
	private Operator log_operator;
	private HttpSession session;
	private String checkResult;
	private Connection conn;
	private ResultSet rs;

	// 登录验证
	public String login(HttpServletRequest request, Operator operator) {
		session = request.getSession();
		checkResult = "success";
		log_operator = new Operator();
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("SELECT * FROM operator WHERE ope_name = ?");
			pst.setString(1, operator.getName());
			rs = pst.executeQuery();
			if (!rs.next()) {
				checkResult = "账户不存在，请重新输入！";
				session.setAttribute("isLogin", "false");
			} else {
				if (!operator.getPwd().equals(rs.getString(3))) {
					checkResult = "您输入的密码不正确，请重新输入！";
					session.setAttribute("isLogin", "false");
				} else {
					// 登录成功
					session.setAttribute("isLogin", "true");

					// 获得该用户的完整信息
					log_operator.setId(rs.getInt(1));
					log_operator.setName(rs.getString(2));
					log_operator.setPwd(rs.getString(3));
					log_operator.setRole(roleImpl.query("rol_id",
							rs.getString(4)).get(0));
					session.setAttribute("log_operator", log_operator);

					// 根据用户，获取对应的角色对应的权限
					list_privilege = privilegeImpl.query("rol_id", log_operator
							.getRole().getId()
							+ "");
					List<Privilege> list = new ArrayList<Privilege>();
					list.add(list_privilege.get(0));
					
					for (int i = 1; i < list_privilege.size(); i++) {
                          int y=0;
						for(int x=0;x<list.size();x++){
							
							if(!list.get(x).getMenu_name().equals(
									list_privilege.get(i).getMenu_name())){
								y++;
							}
						}
						if (y==list.size()) {
							list.add(list_privilege.get(i));

						}

					}
					session.setAttribute("list", list);
					session.setAttribute("list_privilege", list_privilege);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
		return checkResult;
	}
}