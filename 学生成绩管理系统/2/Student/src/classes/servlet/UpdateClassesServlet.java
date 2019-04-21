package classes.servlet;

import impl.ClassesImpl;
import impl.MajorImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Classes;

public class UpdateClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 更新班级信息
		ClassesImpl classesImpl = new ClassesImpl();
		MajorImpl majorImpl = new MajorImpl();
		Classes classes = classesImpl.query("cla_id",
				request.getParameter("cla_id")).get(0);
		classes.setName(request.getParameter("cla_name"));
		classes.setMajor(majorImpl.query("maj_id",
				request.getParameter("maj_id")).get(0));
		classes.setTecName(request.getParameter("cla_tec"));
		classesImpl.update(classes);
		response.sendRedirect("pages/search_classes.jsp");
	}
}
