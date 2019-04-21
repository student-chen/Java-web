package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PageBean;
import model.Score;

import org.omg.CORBA.Request;

import service.Impl.ScoreServiceImpl;

public class ServletSearchScore extends HttpServlet{
	
	private Score score;
	private ScoreServiceImpl scoreServiceImpl=new ScoreServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		doPost(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo=1;
		int pageCount=1;
		String pageNoStr=request.getParameter("pageNo");
		String pageCountStr=request.getParameter("pageCount");
		if(pageNoStr!=null){
			pageNo=Integer.parseInt(pageNoStr);
		}
		if(pageCountStr!=null){
			pageCount=Integer.parseInt(pageCountStr);
		}
		String stuNum=request.getParameter("stuNum");
		String courseName=request.getParameter("cosName");
		String stuName=request.getParameter("stuName");
		String stuClass=request.getParameter("stuClass");
		String major=request.getParameter("major");
		/*if(stuNum==""){
			stuNum=null;
		}
		if(courseName==""){
			courseName=null;
		}
		if(stuName==""){
			stuName=null;
		}
		if(stuClass==""){
			stuClass=null;
		}
		if(major==""){
			major=null;
		}*/
		double scoreGrade=0;
		
		score=new Score( stuNum,  stuName,  stuClass,
				 courseName,  scoreGrade,  major);
		PageBean rs=scoreServiceImpl.selectStuScore(pageNo, pageCount, score);
		request.setAttribute("list", rs);
		request.setAttribute("score", score);
		request.getRequestDispatcher("admin/selectblurScore.jsp").forward(request, response);
	}

}
