package teacher.servlet;

import impl.TeacherImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Operator;
import entity.Teacher;

public class EditTeacherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 准备更新老师的信息
		HttpSession session = request.getSession();
		TeacherImpl teacherImpl = new TeacherImpl();
		Teacher teacher_me = teacherImpl.query("tec_id",
				request.getParameter("tec_id")).get(0);
		Operator operator_me = teacher_me.getOperator();
		session.setAttribute("teacher_me", teacher_me);
		session.setAttribute("operator_me", operator_me);
		response.sendRedirect("pages/update_teacher.jsp");

	}
}
