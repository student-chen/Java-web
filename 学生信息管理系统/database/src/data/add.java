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

public class add extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { // 处理post请求
		this.doPost(req, resp); // 同一种方法体处理
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		Connection conn = null;
		Connection conn1 = null;
		Connection conn2 = null;
		Statement st = null;
		Statement st1 = null;
		Statement st2 = null;
		int id = 0;
		try {
			conn = link.getConnection();
			st = conn.createStatement();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String type = request.getParameter("type");

			st.execute("insert into user (username, password,type) values ('"
					+ username + "','" + password + "','" + type + "')");

			if (type.equals("1")) {
				conn1 = link.getConnection();
				st1 = conn1.createStatement();
				ResultSet rs = st1
						.executeQuery("select * from user where username = '"
								+ username + "' and password = '" + password
								+ "'");
				while (rs.next()) {
					id = rs.getInt("id");
				}
				conn2 = link.getConnection();
				st2 = conn2.createStatement();
				st2.execute("insert into student (id,username) values ('"
						+ id + "','" + username + "')");
			}
			response.sendRedirect("adlist");
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
