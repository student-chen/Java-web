package data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ncourse extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { // 处理post请求
		this.doPost(req, resp); // 同一种方法体处理
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		Connection conn = null;
		Statement st = null;
		Connection conn1 = null;
		Statement st1 = null;
		try {
			conn = link.getConnection();
			st = conn.createStatement();
			String course = request.getParameter("course");
			String teacher = request.getSession().getAttribute("name").toString();
System.out.println(teacher);
			st.execute("insert into course (course,teacher) values ('" + course +"','"+ teacher + "')");

			conn1 = link.getConnection();
			st1 = conn1.createStatement();
			st1.execute("alter table student add column " + course + " int(5)");
			
			response.sendRedirect("tclist");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}
}
