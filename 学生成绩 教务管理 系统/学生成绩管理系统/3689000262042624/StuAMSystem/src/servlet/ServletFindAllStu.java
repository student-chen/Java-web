package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.StudentServiceImpl;

import dao.Impl.StudentDaoImpl;

import model.PageBean;
import model.Student;


public class ServletFindAllStu extends HttpServlet{
	
	private Student student;
	private StudentServiceImpl studentServiceImpl=new StudentServiceImpl();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		int pageNo=1;
		int pageCount=2;
		
		String pageNoStr=request.getParameter("pageNo");
		String pageCountStr=request.getParameter("pageCount");
	
		
		if(pageNoStr!=null){
			pageNo=Integer.parseInt(pageNoStr);
		}
		if(pageCountStr!=null){
			pageCount=Integer.parseInt(pageCountStr);
		}
		
	
		PageBean list=studentServiceImpl.stuListPage(pageNo, pageCount);
	
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/studentAllInfo.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}

}
