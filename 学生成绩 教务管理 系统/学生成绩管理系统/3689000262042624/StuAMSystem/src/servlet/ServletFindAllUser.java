package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.UserServiceImpl;

import dao.Impl.UserDaoImpl;

public class ServletFindAllUser extends HttpServlet{
	
	private UserServiceImpl userServiceImpl=new UserServiceImpl();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		List rs=userServiceImpl.findAll();
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/userAllInfo.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}

}
