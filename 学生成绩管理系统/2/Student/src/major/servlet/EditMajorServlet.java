package major.servlet;

import impl.MajorImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Major;

public class EditMajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 准备更新专业信息
		MajorImpl majorImpl = new MajorImpl();
		HttpSession session = request.getSession();
		
		Major major = majorImpl.query("maj_id", request.getParameter("maj_id"))
				.get(0);
		session.setAttribute("major", major);
		response.sendRedirect("pages/update_major.jsp");
	}
}
