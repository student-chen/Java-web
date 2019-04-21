package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.ScoreServiceImpl;


public class ServletStuAllScore extends HttpServlet{
	
	private ScoreServiceImpl scoreServiceImpl=new ScoreServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String stuNum=request.getParameter("stunum");
		double rs=scoreServiceImpl.findStuSc(stuNum);
		out.print(rs);
		/*request.setAttribute("sum", rs);
		request.getRequestDispatcher("admin/stuScore.jsp").forward(request, response);*/
	
	}

}
