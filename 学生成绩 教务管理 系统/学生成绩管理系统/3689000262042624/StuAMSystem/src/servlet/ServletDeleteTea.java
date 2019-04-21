package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.TeacherServiceImpl;

import dao.Impl.TeacherDaoImpl;
import model.Teacher;

public class ServletDeleteTea extends HttpServlet{

	private Teacher teacher;
	private TeacherServiceImpl teacherServiceImpl=new TeacherServiceImpl();
	private ServletFindAllTea findTea=new ServletFindAllTea();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String teaNum=request.getParameter("teanum");
		int rs=teacherServiceImpl.deleteTea(teaNum);
		if(rs>0){
			request.setAttribute("msg", "É¾³ý³É¹¦£¡£¡");
	//		ServletFindAllStu findStu=new ServletFindAllStu();
			findTea.doGet(request, response);
			
			/*List list=studentDaoImpl.findAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("admin/studentAllInfo.jsp").forward(request, response);*/
		}else{
			request.setAttribute("msg", "É¾³ýÊ§°Ü£¡£¡");
			findTea.doGet(request, response);
			
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
