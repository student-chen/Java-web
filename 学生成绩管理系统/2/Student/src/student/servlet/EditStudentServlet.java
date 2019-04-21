package student.servlet;

import impl.ClassesImpl;
import impl.StudentImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Classes;
import entity.Student;

public class EditStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentImpl studentImpl = new StudentImpl();
		ClassesImpl classesImpl = new ClassesImpl();
		Student student;
		List<Classes> list_classes;
		HttpSession session = request.getSession();
		// 准备更新学生信息
		student = studentImpl.query("stu_id", request.getParameter("stu_id"))
				.get(0);
		list_classes = classesImpl.query("all", "all");
		session.setAttribute("student", student);
		session.setAttribute("list_classes", list_classes);
		response.sendRedirect("pages/update_student.jsp");
	}
}
