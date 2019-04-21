package cla2sub.servlet;

import impl.Cla2SubImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCla2SubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 删除班级课程
		Cla2SubImpl cla2SubImpl = new Cla2SubImpl();
		cla2SubImpl.delete(cla2SubImpl.query("cla2sub_id",
				request.getParameter("cla2sub_id")).get(0));
		response.sendRedirect("pages/search_classes_subject.jsp");
	}
}
