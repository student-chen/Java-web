package servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.ScoreServiceImpl;

import model.PageBean;
import model.Score;

public class ServletTeaSearchScore extends HttpServlet{
	
	private Score score;
	private ScoreServiceImpl scoreServiceImpl=new ScoreServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo=1;
		int pageCount=1;
		String teaName=(String) request.getSession().getAttribute("username");
		String pageNoStr=request.getParameter("pageNo");
		String pageCountStr=request.getParameter("pageCount");
	
		
		if(pageNoStr!=null){
			pageNo=Integer.parseInt(pageNoStr);
		}
		if(pageCountStr!=null){
			pageCount=Integer.parseInt(pageCountStr);
		}
		String stuNum=request.getParameter("stuNum");
		String stuName=request.getParameter("stuName");
		String stuClass=request.getParameter("stuClass");
		score=new Score();
		score.setStuNum(stuNum);
		score.setStuName(stuName);
		score.setStuClass(stuClass);
		PageBean list=scoreServiceImpl.selectTeaScore(pageNo, pageCount, teaName,score);
		request.setAttribute("list", list);
		request.setAttribute("score", score);
		request.getRequestDispatcher("teacher/stuTeaScore.jsp").forward(request, response);
	}

}
