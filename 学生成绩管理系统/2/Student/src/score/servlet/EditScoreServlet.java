package score.servlet;

import impl.ScoreImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Score;

public class EditScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 准备更新学生成绩信息
		ScoreImpl scoreImpl = new ScoreImpl();
		HttpSession session = request.getSession();
		Score score = scoreImpl.query("sco_id", request.getParameter("sco_id"))
				.get(0);
		session.setAttribute("score", score);
		session.setAttribute("student", score.getStudent());
		session.setAttribute("subject", score.getSubject());
		response.sendRedirect("pages/update_score.jsp");
	}
}
