package subject.servlet;

import impl.SubjectImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Subject;

public class EditSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 准备更新课程数据
		SubjectImpl subjectImpl = new SubjectImpl();
		Subject subject = subjectImpl.query("sub_id",
				request.getParameter("sub_id")).get(0);
		request.getSession().setAttribute("subject", subject);
		response.sendRedirect("pages/update_subject.jsp");
	}
}
