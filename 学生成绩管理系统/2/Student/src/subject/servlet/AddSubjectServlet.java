package subject.servlet;

import impl.SubjectImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Subject;

public class AddSubjectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 添加课程
		SubjectImpl subjectImpl = new SubjectImpl();
		Subject subject = new Subject();
		subject.setName(request.getParameter("sub_name"));
		subject.setType(request.getParameter("sub_type"));
		subject.setTimes(Integer.parseInt(request.getParameter("sub_times")));
		int i=subjectImpl.add(subject);
		if (i == 1) {
			request.getSession().setAttribute("message", "添加科目成功！");
		} else {
			request.getSession().setAttribute("message", "添加科目失败！");
		}
		response.sendRedirect("pages/add_subject.jsp");
	}
}
