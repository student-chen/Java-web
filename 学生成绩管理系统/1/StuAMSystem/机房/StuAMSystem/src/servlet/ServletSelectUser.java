package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.UserServiceImpl;


public class ServletSelectUser extends HttpServlet{
	
	private UserServiceImpl userServiceImpl=new UserServiceImpl();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		int userID=Integer.parseInt(request.getParameter("userID"));
		List rs=userServiceImpl.selectOneUser(userID);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editUser.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}

}
