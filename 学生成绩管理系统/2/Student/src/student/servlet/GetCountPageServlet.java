package student.servlet;

import impl.StudentImpl;
import impl.TeacherImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Operator;
import entity.Teacher;

public class GetCountPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentImpl studentImpl = new StudentImpl();
		TeacherImpl teacherImpl = new TeacherImpl();
		Operator operator;
		Teacher teacher;

		// 获取总页数
		int countPage = 0;
		operator = (Operator) request.getSession().getAttribute("log_operator");
		int ope_rol_id = operator.getRole().getId();
	
		String search_type = request.getParameter("search_type");
		String search_value = java.net.URLDecoder.decode(request
				.getParameter("value"), "UTF-8");
		if (ope_rol_id == 1) {
			// 管理员的查询
			if (search_type.equals("stu_all")) {
				countPage = studentImpl.getCountPage("stu_all", search_value
						+ "");
			} else if (search_type.equals("stu_no")) {
				countPage = studentImpl.getCountPage("stu_no", search_value
						+ "");
			} else if (search_type.equals("stu_name")) {
				countPage = studentImpl.getCountPage("stu_name", search_value
						+ "");
			} else if (search_type.equals("cla_name")) {
				countPage = studentImpl.getCountPage("cla_name", search_value
						+ "");
			} else if (search_type.equals("maj_name")) {
				countPage = studentImpl.getCountPage("maj_name", search_value
						+ "");
			}
		} else if (ope_rol_id == 2) {
			// 老师的查询
			teacher = teacherImpl.query("ope_id", operator.getId()/* 3 */+ "")
					.get(0);
			if (search_type.equals("stu_all")) {
				countPage = studentImpl.getCountPage("tec_stu_all", teacher
						.getName());
			} else if (search_type.equals("stu_no")) {
				countPage = studentImpl.getCountPage("tec_stu_no", teacher
						.getName()
						+ "_" + search_value);
			} else if (search_type.equals("stu_name")) {
				countPage = studentImpl.getCountPage("tec_stu_name", teacher
						.getName()
						+ "_" + search_value);
			} else if (search_type.equals("cla_name")) {
				countPage = studentImpl.getCountPage("tec_cla_name", teacher
						.getName()
						+ "_" + search_value);
			} else if (search_type.equals("maj_name")) {
				countPage = studentImpl.getCountPage("tec_maj_name", teacher
						.getName()
						+ "_" + search_value);
			}
		}
		// 直接将数字写入的话会报错？
		response.getWriter().write(countPage + "");
	}
}
