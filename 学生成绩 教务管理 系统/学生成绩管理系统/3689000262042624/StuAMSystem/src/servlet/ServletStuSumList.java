package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PageBean;

import service.Impl.ScoreServiceImpl;

public class ServletStuSumList extends HttpServlet{
	
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
		String pageNoStr=request.getParameter("pageNo");
		String pageCountStr=request.getParameter("pageCount");
		if(pageNoStr!=null){
			pageNo=Integer.parseInt(pageNoStr);
		}
		if(pageCountStr!=null){
			pageCount=Integer.parseInt(pageCountStr);
		}
		PageBean rs=scoreServiceImpl.selectScoreSum(pageNo, pageCount);
		request.setAttribute("list", rs);
		int num=(pageNo-1)*pageCount;
		request.setAttribute("num", num);
		request.getRequestDispatcher("admin/stuScoreList.jsp").forward(request, response);
	}

}
