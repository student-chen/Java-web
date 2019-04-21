package student.servlet;

import impl.ClassesImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Classes;

public class PlanAddStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassesImpl classesImpl = new ClassesImpl();
		List<Classes> list_classes;
		HttpSession session = request.getSession();
		// 准备添加学生，查询可用班级
		list_classes = classesImpl.query("all", "all");
		session.setAttribute("list_classes", list_classes);
		response.sendRedirect("pages/add_student.jsp");
	}
}
