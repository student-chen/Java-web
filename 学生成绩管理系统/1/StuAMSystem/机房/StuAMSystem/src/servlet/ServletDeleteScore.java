package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Score;
import service.Impl.ScoreServiceImpl;



public class ServletDeleteScore extends HttpServlet{

	private Score score;
	private ServletFindAllScore servletFindAllScore=new ServletFindAllScore();
	private ScoreServiceImpl scoreServiceImpl=new ScoreServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int scoreID = Integer.parseInt(request.getParameter("scoreID"));
	
		int rs=scoreServiceImpl.deleteScore(scoreID);
		if(rs>0){
			request.setAttribute("msg", "删除成功！！");
			servletFindAllScore.doGet(request, response);
		}else{
			request.setAttribute("msg", "删除成功！！");
			servletFindAllScore.doGet(request, response);
		}
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	

}
