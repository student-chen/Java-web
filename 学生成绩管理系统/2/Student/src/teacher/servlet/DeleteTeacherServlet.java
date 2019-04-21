package teacher.servlet;

import impl.TeacherImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteTeacherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 删除教师，检测是否带班，有的话也连删，数据库触发器无法实现，只能这里多一步
		TeacherImpl teacherImpl = new TeacherImpl();
		teacherImpl.delete(teacherImpl.query("tec_id",
				request.getParameter("tec_id")).get(0));
		response.sendRedirect("pages/search_teacher.jsp");

	}
}
