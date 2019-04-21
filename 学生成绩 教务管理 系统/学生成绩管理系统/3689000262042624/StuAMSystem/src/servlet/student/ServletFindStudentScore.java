package servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.ScoreServiceImpl;

import dao.Impl.ScoreDaoImpl;

import model.PageBean;
import model.Student;


public class ServletFindStudentScore extends HttpServlet{
	
	private Student student;
	private ScoreServiceImpl scoreServiceImpl=new ScoreServiceImpl();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		int pageNo=1;
		int pageCount=1;
		String stuNum=(String) request.getSession().getAttribute("usernum");
		
		String pageNoStr=request.getParameter("pageNo");
		String pageCountStr=request.getParameter("pageCount");
	
		
		if(pageNoStr!=null){
			pageNo=Integer.parseInt(pageNoStr);
		}
		if(pageCountStr!=null){
			pageCount=Integer.parseInt(pageCountStr);
		}
		
		PageBean rs=scoreServiceImpl.scoreListPage(pageNo, pageCount, stuNum);
		
		request.setAttribute("list", rs);
		request.getRequestDispatcher("student/selectScore.jsp").forward(request, response);
	
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}

}
