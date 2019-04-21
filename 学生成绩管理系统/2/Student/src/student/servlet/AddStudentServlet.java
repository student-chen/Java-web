package student.servlet;

import impl.Cla2SubImpl;
import impl.ClassesImpl;
import impl.OperatorImpl;
import impl.PictureImpl;
import impl.RoleImpl;
import impl.ScoreImpl;
import impl.StudentImpl;
import impl.SubjectImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;

import entity.Cla2Sub;
import entity.Operator;
import entity.Score;
import entity.Student;
import entity.Subject;

public class AddStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		OperatorImpl operatorImpl = new OperatorImpl();
		PictureImpl pictureImpl = new PictureImpl();
		StudentImpl studentImpl = new StudentImpl();
		ClassesImpl classesImpl = new ClassesImpl();
		SubjectImpl subjectImpl = new SubjectImpl();
		ScoreImpl scoreImpl = new ScoreImpl();
		RoleImpl roleImpl = new RoleImpl();
		// 添加新学生
		try {
			SmartUpload sm = new SmartUpload();
			sm.initialize(getServletConfig(), request, response);
			sm.upload();

			Student student = new Student();
			Operator operator = new Operator();

			// 为学生添加操作员信息记录
			operator.setName(sm.getRequest().getParameter("ope_name"));
			operator.setPwd(sm.getRequest().getParameter("ope_pwd"));
			operator.setRole(roleImpl.query("rol_id", "3").get(0));
			operator = operatorImpl.add(operator);

			// 将学生添加到学生表
			student.setOperator(operator);
			student.setNo(sm.getRequest().getParameter("no"));
			student.setName(sm.getRequest().getParameter("name"));
			student
					.setSex(sm.getRequest().getParameter("sex").equals("male") ? "男"
							: "女");
			student.setBirth(sdf.parse(sm.getRequest().getParameter("birth")));
			student.setClasses(classesImpl.query("cla_id",
					sm.getRequest().getParameter("cla_id")).get(0));
			pictureImpl.check(getServletConfig(), request, response, sm,
					student);
			int i = studentImpl.add(student);
			student = studentImpl.query("ope_id", operator.getId() + "").get(0);
			if (i == 1) {
				request.getSession().setAttribute("message", "添加学生成功！");
			} else {
				request.getSession().setAttribute("message", "添加学生失败！");
			}

			// 为学生添加课程成绩记录信息

			List<Subject> list_subject = subjectImpl.query("stu_id", student
					.getId()
					+ "");
			List<Cla2Sub> list_cla2sub = new Cla2SubImpl().query("stu_id",
					student.getId() + "");
			for (int x = 0; x < list_subject.size(); x++) {
				Score score = new Score();
				score.setStudent(student);
				score.setSubject(list_subject.get(x));
				score.setCla2sub(list_cla2sub.get(x));
				scoreImpl.add(score);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("pages/add_student.jsp");

	}

}
