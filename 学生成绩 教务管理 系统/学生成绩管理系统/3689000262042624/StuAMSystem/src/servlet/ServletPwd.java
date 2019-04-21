package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.UserServiceImpl;

import model.User;
import dao.Impl.UserDaoImpl;

public class ServletPwd extends HttpServlet{
	
	private User user;
	private UserServiceImpl userServiceImpl=new UserServiceImpl();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String userNum=(String) request.getSession().getAttribute("usernum");
		user=new User();
		user.setUserNum(userNum);
		User rs=userServiceImpl.login(user);
		String pwd=rs.getPassword();
		request.setAttribute("password", pwd);
		request.getRequestDispatcher("admin/updatePwd.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}
}
