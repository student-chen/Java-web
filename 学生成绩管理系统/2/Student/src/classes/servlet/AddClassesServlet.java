package classes.servlet;

import impl.ClassesImpl;
import impl.MajorImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Classes;

public class AddClassesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 添加新班级
		ClassesImpl classesImpl = new ClassesImpl();
		MajorImpl majorImpl = new MajorImpl();
		Classes classes = new Classes();
		classes.setName(request.getParameter("cla_name"));
		classes.setMajor(majorImpl.query("maj_id",
				request.getParameter("maj_id")).get(0));
		classes.setTecName(request.getParameter("cla_tec"));
		classes = classesImpl.add(classes);
		System.out.println(classes.getId());
		if (classes != null) {
			request.getSession().setAttribute("message", "添加班级成功！");
		} else {
			request.getSession().setAttribute("message", "添加班级失败！");
		}
		response.sendRedirect("pages/add_classes.jsp");

	}
}
