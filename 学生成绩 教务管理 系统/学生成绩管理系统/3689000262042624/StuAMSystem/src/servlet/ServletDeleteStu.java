package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.StudentServiceImpl;

import model.Student;
import dao.Impl.StudentDaoImpl;

public class ServletDeleteStu extends HttpServlet{
	
	private Student student;
	private StudentServiceImpl studentServiceImpl=new StudentServiceImpl();
	private ServletFindAllStu findStu=new ServletFindAllStu();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String stuNum=request.getParameter("stunum");
		int rs=studentServiceImpl.deleteStu(stuNum);
		if(rs>0){
			request.setAttribute("msg", "É¾³ý³É¹¦£¡£¡");
	//		ServletFindAllStu findStu=new ServletFindAllStu();
			findStu.doGet(request, response);
			
			/*List list=studentDaoImpl.findAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("admin/studentAllInfo.jsp").forward(request, response);*/
		}else{
			request.setAttribute("msg", "É¾³ýÊ§°Ü£¡£¡");
			findStu.doGet(request, response);
			
			/*List list=studentDaoImpl.findAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("admin/studentAllInfo.jsp").forward(request, response);*/
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}

}
