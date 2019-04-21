package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.ScoreServiceImpl;

import model.Score;

import dao.Impl.ScoreDaoImpl;

public class ServletSelectScore extends HttpServlet{
	
	private Score score;
	private ScoreServiceImpl scoreServiceImpl=new ScoreServiceImpl();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		int scoreID=Integer.parseInt(request.getParameter("scoreID"));
		
		List rs=scoreServiceImpl.selectScore(scoreID);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editScore.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}

}
