package classes.servlet;

import impl.ClassesImpl;
import impl.MajorImpl;
import impl.TeacherImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Classes;
import entity.Major;
import entity.Teacher;

public class EditClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 准备更新班级信息，直属教师，直属专业
		TeacherImpl teacherImpl = new TeacherImpl();
		ClassesImpl classesImpl = new ClassesImpl();
		MajorImpl majorImpl = new MajorImpl();
		List<Teacher> list_teacher;
		List<Major> list_major;
		HttpSession session = request.getSession();
		Classes classes = classesImpl.query("cla_id",
				request.getParameter("cla_id")).get(0);
		list_teacher = teacherImpl.query("all", "all");
		list_major = majorImpl.query("all", "all");
		session.setAttribute("classes", classes);
		session.setAttribute("list_teacher", list_teacher);
		session.setAttribute("list_major", list_major);
		response.sendRedirect("pages/update_classes.jsp");
	}
}
