package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

import service.Impl.StudentServiceImpl;

@SuppressWarnings("serial")
public class ServletFindStu extends HttpServlet{

	private Student student;
	private StudentServiceImpl studentServiceImpl=new StudentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/xml;charset=utf-8");
		String stuNum=request.getParameter("stunum");
		List rs=studentServiceImpl.findOne(stuNum);
		for(int i=0;i<rs.size();i++){
			 student=(Student) rs.get(i);
			
		}
		StringBuffer s=new StringBuffer();
		s.append("<msg>");
		s.append("<title>"+student.getStuName()+"</title>");
		s.append("<title>"+student.getStuClass()+"</title>");
		s.append("<title>"+student.getMajor()+"</title>");
		s.append("</msg>");
	
		PrintWriter out=response.getWriter();
		out.print(s.toString());
	//	response.
		
	}

}
