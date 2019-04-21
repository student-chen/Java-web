package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.ScoreServiceImpl;

import model.Score;
import dao.Impl.ScoreDaoImpl;

public class ServletEditScore extends HttpServlet{

	private Score score;
	private ServletFindAllScore servletFindAllScore=new ServletFindAllScore();
	private ScoreServiceImpl scoreServiceImpl=new ScoreServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int scoreID = Integer.parseInt(request.getParameter("scoreID"));
		String stuNum = request.getParameter("stuNum");
		String stuName = request.getParameter("stuName");
		String stuClass = request.getParameter("stuClass");
		String courseName = request.getParameter("courseName");
		double scoreGrade=Double.parseDouble(request.getParameter("scoreGrade"));
		String major = request.getParameter("major");
		
		score=new Score(scoreID,stuNum,stuName,stuClass,courseName,scoreGrade,major);
		int rs=scoreServiceImpl.editCos(score);
		if(rs>0){
			request.setAttribute("msg", "修改成功！！");
			servletFindAllScore.doGet(request, response);
			//	request.getRequestDispatcher("admin/addCourse.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "修改失败！！");
			request.getRequestDispatcher("admin/editScore.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
