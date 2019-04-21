package student.servlet;

import impl.ClassesImpl;
import impl.StudentImpl;
import impl.TeacherImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Classes;
import entity.Operator;
import entity.Student;
import entity.Teacher;

public class SearchTeacherClassServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentImpl studentImpl = new StudentImpl();
		ClassesImpl classesImpl = new ClassesImpl();
		TeacherImpl teacherImpl = new TeacherImpl();
		Operator operator;
		Classes classes;
		List<Student> list_student;
		HttpSession session = request.getSession();
		// 老师查找自己的班级学生
		operator = (Operator) request.getSession().getAttribute("log_operator");
		Teacher teacher = teacherImpl.query("ope_id", operator.getId() + "")
				.get(0);
		if (classesImpl.query("cla_tec", teacher.getName()).size() <= 0) {
			response.sendRedirect("pages/noclass.jsp");
		} else {
			classes = classesImpl.query("cla_tec", teacher.getName()).get(0);

			list_student = studentImpl.query("cla_id", classes.getId() + "");
			session.setAttribute("list_student", list_student);
			session.setAttribute("classes", classes);
			session.setAttribute("teacher", teacher);
			session.setAttribute("studentNum", list_student.size());
			response.sendRedirect("pages/search_classmate.jsp");
		}

	}
}
