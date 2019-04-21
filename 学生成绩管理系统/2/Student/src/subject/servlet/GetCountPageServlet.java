package subject.servlet;

import impl.StudentImpl;
import impl.SubjectImpl;
import impl.TeacherImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Operator;
import entity.Student;
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
		// 获取总页数
		TeacherImpl teacherImpl = new TeacherImpl();
		StudentImpl studentImpl = new StudentImpl();
		SubjectImpl subjectImpl = new SubjectImpl();
		Operator operator;
		Student student;
		Teacher teacher;
		int countPage = 0;
		operator = (Operator) request.getSession().getAttribute("log_operator");
		int ope_rol_id = operator.getRole().getId();
		String search_type = request.getParameter("search_type");
		String search_value = java.net.URLDecoder.decode(request
				.getParameter("value"), "UTF-8");
		if (ope_rol_id == 1) {
			// 管理员的查询
			if (search_type.equals("stu_all")) {
				countPage = subjectImpl.getCountPage("all", search_value);
			} else {
				countPage = subjectImpl.getCountPage(search_type, search_value);
			}
		} else if (ope_rol_id == 2) {
			// 老师的查询
			teacher = teacherImpl.query("ope_id", operator.getId() + "").get(0);
			// teacher = teacherImpl.query("ope_id", 2+ "").get(0);
			if (search_type.equals("stu_all")) {
				countPage = subjectImpl.getCountPage("tec_stu_all", teacher
						.getId()
						+ "");
			} else if (search_type.equals("sub_name")) {
				countPage = subjectImpl.getCountPage("tec_sub_name", teacher
						.getId()
						+ "_" + search_value);
			} else if (search_type.equals("cla_name")) {
				countPage = subjectImpl.getCountPage("tec_cla_name", teacher
						.getId()
						+ "_" + search_value);
			} else if (search_type.equals("stu_name")) {
				countPage = subjectImpl.getCountPage("tec_stu_name", teacher
						.getId()
						+ "_" + search_value);
			} else if (search_type.equals("tec_name")) {
				countPage = subjectImpl.getCountPage("tec_tec_name", teacher
						.getId()
						+ "_" + search_value);
			}
		} else {
			// 学生查询
			student = studentImpl.query("ope_id", operator.getId() + "").get(0);
			if (search_type.equals("stu_all")){
				countPage = subjectImpl.getCountPage("stu_all", student.getId()
						+ "");
				}else if(search_type.equals("stu_tec_name")){
					countPage = subjectImpl.getCountPage("stu_tec_name", student
							.getId()
							+ "_" + search_value);
				}
			else
				countPage = subjectImpl.getCountPage("stu_sub_name", student
						.getId()
						+ "_" + search_value);
		}

		// 直接将数字写入的话会报错？
		response.getWriter().write(countPage + "");
	}
}
