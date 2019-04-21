package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.UserServiceImpl;

import model.User;

import dao.Impl.UserDaoImpl;

public class ServletEditUser extends HttpServlet{
	
	private User user;
	private ServletFindAllUser servletFindAllUser=new ServletFindAllUser();
	private UserServiceImpl userServiceImpl=new UserServiceImpl();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String userNum=request.getParameter("userNum");
		String userName=request.getParameter("userName");
		String pwd=request.getParameter("password");
		String phone=request.getParameter("phone");
		int roleID=Integer.parseInt(request.getParameter("roleID"));
		user=new User(userNum,userName,pwd,phone,roleID);
		int rs=userServiceImpl.editUser(user);
		if(rs>0){
			request.setAttribute("msg", "修改成功！！");
			servletFindAllUser.doGet(request, response);
		}else{
			request.setAttribute("msg", "修改失败！！");
			servletFindAllUser.doGet(request, response);
		//	request.getRequestDispatcher("admin/selectPwd.jsp").forward(request, response);
		}
		/*int userID=Integer.parseInt(request.getParameter("userID"));
		List rs=userDaoImpl.selectOneUser(userID);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editUser.jsp").forward(request, response);*/
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}

}
