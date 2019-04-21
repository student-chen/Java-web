package subject.servlet;

import impl.SubjectImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Subject;

public class UpdateSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 更新课程数据
		SubjectImpl subjectImpl = new SubjectImpl();
		Subject subject = subjectImpl.query("sub_id",
				request.getParameter("sub_id")).get(0);
		subject.setName(request.getParameter("sub_name"));
		subject.setType(request.getParameter("sub_type"));
		subject.setTimes(Integer.parseInt(request.getParameter("sub_times")));
		subjectImpl.update(subject);
		response.sendRedirect("pages/search_subject.jsp");
	}
}
