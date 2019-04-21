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

public class InfoTeacherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 查询老师的个人信息
		HttpSession session = request.getSession();
		Operator operator = (Operator) request.getSession().getAttribute(
				"log_operator");
		Teacher teacher = new TeacherImpl().query("ope_id",
				operator.getId() + "").get(0);
		session.setAttribute("operator_me", operator);
		session.setAttribute("teacher_me", teacher);
		response.sendRedirect("pages/info_teacher.jsp");

	}

}
