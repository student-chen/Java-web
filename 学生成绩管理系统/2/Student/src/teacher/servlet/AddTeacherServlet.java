package teacher.servlet;

import impl.OperatorImpl;
import impl.RoleImpl;
import impl.TeacherImpl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Operator;
import entity.Teacher;

public class AddTeacherServlet extends HttpServlet {
	/**
	 * 
	 */
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
		// TODO Auto-generated method stub
		Operator operator = new Operator();
		Teacher teacher = new Teacher();
		RoleImpl roleImpl = new RoleImpl();
		TeacherImpl teacherImpl = new TeacherImpl();
		OperatorImpl operatorImpl = new OperatorImpl();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			teacher.setBirth(sdf.parse((request.getParameter("tec_birth"))));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		operator.setName(request.getParameter("ope_name"));
		operator.setPwd(request.getParameter("ope_pwd"));
		operator.setRole(roleImpl.query("rol_id", "2").get(0));
		teacher.setSex((request.getParameter("tec_sex")).equals("male") ? "男"
				: "女");
		teacher.setMajor(request.getParameter("tec_major"));
		teacher.setPhone(request.getParameter("tec_phone"));
		teacher.setName(request.getParameter("tec_name"));
		operator = operatorImpl.add(operator);
		teacher.setOperator(operator);
		int i = teacherImpl.add(teacher);
		if (i == 1) {
			request.getSession().setAttribute("message", "添加老师成功！");
		} else {
			request.getSession().setAttribute("message", "添加老师失败！");
		}
		response.sendRedirect("pages/add_teacher.jsp");
	}
}
