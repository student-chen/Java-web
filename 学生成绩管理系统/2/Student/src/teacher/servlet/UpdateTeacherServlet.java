package teacher.servlet;

import impl.OperatorImpl;
import impl.TeacherImpl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Operator;
import entity.Teacher;

public class UpdateTeacherServlet extends HttpServlet {

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
		// 更新老师信息
		HttpSession session = request.getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		OperatorImpl operatorImpl = new OperatorImpl();
		TeacherImpl teacherImpl = new TeacherImpl();
		Teacher teacher = teacherImpl.query("tec_id",
				request.getParameter("tec_id")).get(0);
		Operator operator = teacher.getOperator();
		try {
			teacher.setBirth(sdf.parse((request.getParameter("tec_birth"))));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		teacher.setSex((request.getParameter("tec_sex")).equals("male") ? "男"
				: "女");
		teacher.setName(request.getParameter("tec_name"));
		teacher.setMajor(request.getParameter("tec_major"));
		teacher.setPhone(request.getParameter("tec_phone"));
		operator.setName(request.getParameter("ope_name"));
		operator.setPwd(request.getParameter("ope_pwd"));
		operatorImpl.update(operator);
		teacherImpl.update(teacher);
		session.setAttribute("operator_me", operator);
		session.setAttribute("teacher_me", teacher);
		response.sendRedirect("pages/info_teacher.jsp");

	}
}
