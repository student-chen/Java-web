package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.UserServiceImpl;

import dao.Impl.UserDaoImpl;

import model.User;


public class ServletLogin extends HttpServlet{
	private User user;
	private UserServiceImpl userServiceImpl=new UserServiceImpl();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		String num=request.getParameter("ID");
		String pwd=request.getParameter("pwd");
		int roleID=Integer.parseInt(request.getParameter("role")); 
		user=new User(num,pwd,roleID);
		User rs=userServiceImpl.login(user);
		if(rs.getUserName()!=null){
			if(rs.getUserNum().equals(user.getUserNum())){
				if(rs.getPassword().equals(user.getPassword())){
					if(rs.getRoleID()==user.getRoleID()){
						if(rs.getRoleID()==2){
							request.getSession().setAttribute("username", rs.getUserName());
							request.getSession().setAttribute("usernum", rs.getUserNum());
							request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
						}else if(rs.getRoleID()==1){
							request.getSession().setAttribute("username", rs.getUserName());
							request.getSession().setAttribute("usernum", rs.getUserNum());
							request.getRequestDispatcher("teacher/teacher.jsp").forward(request, response);
						}else if(rs.getRoleID()==0){
							request.getSession().setAttribute("username", rs.getUserName());
							request.getSession().setAttribute("usernum", rs.getUserNum());
							request.getRequestDispatcher("student/student.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("massage","角色不正确！！");
						request.getRequestDispatcher("login/login.jsp").forward(request, response);
					}
				}else{
					request.setAttribute("massage","密码不正确！！");
					request.getRequestDispatcher("login/login.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("massage","用户不存在！！");
				request.getRequestDispatcher("login/login.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("massage","用户不存在！！");
			request.getRequestDispatcher("login/login.jsp").forward(request, response);
		}
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
			doGet(request,response);
		}
}
