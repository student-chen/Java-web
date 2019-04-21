package cla2sub.servlet;

import impl.SubjectImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;
import entity.Subject;

public class SearchCla2Sub_exServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 查询可选班级课程，以及已经选了的班级课程
		SubjectImpl subjectImpl = new SubjectImpl();
		String search_value = new String(request.getParameter("value")
				.getBytes("ISO8859-1"), "UTF-8");
		List<List<Subject>> data = new ArrayList<List<Subject>>();
		List<Subject> list_subject_able = subjectImpl.query("subject_able",
				search_value);
		List<Subject> list_subject_unable = subjectImpl.query("subject_unable",
				search_value);
		data.add(list_subject_able);
		data.add(list_subject_unable);
		response.getWriter().write(JSONSerializer.toJSON(data).toString());
	}
}