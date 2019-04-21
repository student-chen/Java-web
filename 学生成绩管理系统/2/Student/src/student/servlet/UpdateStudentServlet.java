package student.servlet;

import impl.ClassesImpl;
import impl.OperatorImpl;
import impl.PictureImpl;
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
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.SmartUpload;

import entity.Classes;
import entity.Operator;
import entity.Score;
import entity.Student;
import entity.Subject;

public class UpdateStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		OperatorImpl operatorImpl = new OperatorImpl();
		PictureImpl pictureImpl = new PictureImpl();
		StudentImpl studentImpl = new StudentImpl();
		ClassesImpl classesImpl = new ClassesImpl();
		SubjectImpl subjectImpl = new SubjectImpl();
		ScoreImpl scoreImpl = new ScoreImpl();
		List<Score> list_score;
		List<Subject> list_subject;
		HttpSession session = request.getSession();
		// 更新学生信息
		try {
			SmartUpload sm = new SmartUpload();
			sm.initialize(getServletConfig(), request, response);
			sm.upload();

			Student student_my = studentImpl.query("stu_id",
					request.getParameter("stu_id") + "").get(0);
			Operator operator_my = operatorImpl.query("ope_id",
					student_my.getOperator().getId() + "").get(0);

			student_my.setNo(sm.getRequest().getParameter("no"));
			student_my.setName(sm.getRequest().getParameter("name"));

			operator_my.setName(sm.getRequest().getParameter("log_name"));
			operator_my.setPwd(sm.getRequest().getParameter("log_pwd"));

			student_my.setSex(sm.getRequest().getParameter("sex")
					.equals("male") ? "男" : "女");
			student_my.setBirth(sdf
					.parse(sm.getRequest().getParameter("birth")));
			Classes new_classes = classesImpl.query("cla_id",
					sm.getRequest().getParameter("cla_id")).get(0);
			if (new_classes.getId() != student_my.getClasses().getId()) {
				// 班级变动了，删除以前的全部成绩
				list_score = scoreImpl.query("stu_id", student_my.getId() + "");
				for (Score sco : list_score)
					scoreImpl.delete(sco);
				// 添加新的成绩
				list_subject = subjectImpl.query("cla_id", new_classes.getId()
						+ "");
				for (Subject subject : list_subject) {
					Score score = new Score();
					score.setStudent(student_my);
					score.setSubject(subject);
					scoreImpl.add(score);
				}
			}
			student_my.setClasses(new_classes);
			student_my.setOperator(operator_my);

			pictureImpl.check(getServletConfig(), request, response, sm,
					student_my);
			studentImpl.update(student_my);
			operatorImpl.update(operator_my);

			session.setAttribute("student_me", student_my);
			response.sendRedirect("pages/info_student.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
