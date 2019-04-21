package classes.servlet;

import impl.ClassesImpl;
import impl.MajorImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;
import entity.Classes;
import entity.Major;

public class SearchClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// AJAX异步查询班级,管理员
		ClassesImpl classesImpl = new ClassesImpl();
		MajorImpl majorImpl = new MajorImpl();
		List<Classes> list_classes;
		List<Object> data = new ArrayList<Object>();
		List<Major> list_major = new ArrayList<Major>();
		String search_type = request.getParameter("search_type");
		String search_value = java.net.URLDecoder.decode(request
				.getParameter("value"), "UTF-8");
		System.out.println(search_value);
		int page = Integer.parseInt(request.getParameter("page"));
		list_classes = classesImpl.query(search_type, search_value, page);
		for (Classes classes : list_classes) {
			list_major.add(majorImpl.query("cla_id", classes.getId() + "").get(
					0));
		}
		for (int i = 0; i < list_classes.size(); i++) {
			List<Object> list = new ArrayList<Object>();
			list.add(list_classes.get(i));
			list.add(list_major.get(i));
			data.add(list);
		}
		response.getWriter().write(JSONSerializer.toJSON(data).toString());
	}
}
