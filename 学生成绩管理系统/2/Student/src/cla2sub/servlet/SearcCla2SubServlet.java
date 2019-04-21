package cla2sub.servlet;

import impl.Cla2SubImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;
import entity.Cla2Sub;

public class SearcCla2SubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 异步查询班级课程
		Cla2SubImpl cla2SubImpl = new Cla2SubImpl();
		List<Cla2Sub> list_cla2Sub;
		String search_type = request.getParameter("search_type");
		String search_value = java.net.URLDecoder.decode(request
				.getParameter("value"), "UTF-8");
		int page = Integer.parseInt(request.getParameter("page"));
		list_cla2Sub = cla2SubImpl.query(search_type, search_value, page);
		response.getWriter().write(
				JSONSerializer.toJSON(list_cla2Sub).toString());
	}
}

