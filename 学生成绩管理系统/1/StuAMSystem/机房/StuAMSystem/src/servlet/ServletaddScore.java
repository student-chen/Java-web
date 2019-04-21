package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Score;
import service.Impl.ScoreServiceImpl;

public class ServletaddScore extends HttpServlet{

	private Score score;
	private ServletFindAllScore servletFindAllScore=new ServletFindAllScore();
	private ScoreServiceImpl scoreServiceImpl=new ScoreServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stuNum = request.getParameter("stuNum");
		String stuName = request.getParameter("stuName");
		String stuClass = request.getParameter("stuClass");
		String courseName = request.getParameter("courseName");
		double scoreGrade=Double.parseDouble(request.getParameter("scoreGrade"));
		String major = request.getParameter("major");
		
		score=new Score(stuNum,stuName,stuClass,courseName,scoreGrade,major);
		Score scor=scoreServiceImpl.selectScoreInfo(score);
		if(scor==null){
			int rs=scoreServiceImpl.addScore(score);
			if(rs>0){
				request.setAttribute("msg", "娣诲姞鎴愬姛锛侊紒");
				servletFindAllScore.doGet(request, response);
			//	request.getRequestDispatcher("admin/addCourse.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "娣诲姞澶辫触锛侊紒");
				request.getRequestDispatcher("admin/addScore.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "璇ョ敓鐨勬湰闂ㄨ鎴愮哗宸插綍鍏ワ紝璇烽噸鏂板綍鍏ワ紒锛�");
			request.getRequestDispatcher("admin/addScore.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
