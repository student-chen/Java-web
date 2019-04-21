package servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.ScoreServiceImpl;

public class ServletOneStudentScore extends HttpServlet{
	
	private ScoreServiceImpl scoreServiceImpl=new ScoreServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String courseName=request.getParameter("cosName");
		String stuNum=(String) request.getSession().getAttribute("usernum");
		List rs=scoreServiceImpl.findStuOne(stuNum, courseName);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("student/scoreOne.jsp").forward(request, response);
	}

}
