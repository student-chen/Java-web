package major.servlet;

import impl.MajorImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Major;

public class AddMajorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 添加专业
		MajorImpl majorImpl = new MajorImpl();
		Major major = new Major();
		major.setName(request.getParameter("maj_name"));
		major.setPrin(request.getParameter("maj_prin"));
		major.setLink(request.getParameter("maj_link"));
		major.setPhone(request.getParameter("maj_phone"));
		int i = majorImpl.add(major);
		if (i == 1) {
			request.getSession().setAttribute("message", "添加专业成功！");
		} else {
			request.getSession().setAttribute("message", "添加专业失败！");
		}
		response.sendRedirect("pages/add_major.jsp");
	}
}
