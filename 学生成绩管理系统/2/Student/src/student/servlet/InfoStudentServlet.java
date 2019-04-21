package student.servlet;

import impl.StudentImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Operator;
import entity.Student;

public class InfoStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentImpl studentImpl = new StudentImpl();
		Operator operator;
		Student student;
		HttpSession session = request.getSession();

		// 查询自己的信息
		operator = (Operator) request.getSession().getAttribute("log_operator");
		student = studentImpl.query("ope_id", operator.getId() + "").get(0);
		session.setAttribute("student_me", student);
		response.sendRedirect("pages/info_student.jsp");

	}

}
