package major.servlet;

import impl.MajorImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;
import entity.Major;

public class SearchMajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// AJAX异步查询专业
		List<Major> list_major = new ArrayList<Major>();
		MajorImpl majorImpl = new MajorImpl();
		String search_type = request.getParameter("search_type");
		String search_value = java.net.URLDecoder.decode(request
				.getParameter("value"), "UTF-8");
		int page = Integer.parseInt(request.getParameter("page"));
		list_major = majorImpl.query(search_type, search_value, page);
		response.getWriter()
				.write(JSONSerializer.toJSON(list_major).toString());
	}
}
