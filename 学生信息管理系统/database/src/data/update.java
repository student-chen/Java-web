package data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class update extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		Connection conn = null;
		Statement st = null;
		try {
			conn = link.getConnection();
			st = conn.createStatement();
			String id = request.getParameter("id");
			ResultSet rs = st.executeQuery("select * from user where id = "
					+ id);
			if (rs.next()) {
				user user = new user();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setType(rs.getString("type"));
				request.setAttribute("user", user);
			}
			request.getRequestDispatcher("update.jsp").forward(request,
					response);
			return;
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
			String id = request.getParameter("id");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String type = request.getParameter("type");
			st.execute("update user set username = '" + username
					+ "', password = '" + password+ "', type = '" + type + "' where id = " + id);

			conn1 = link.getConnection();
			st1 = conn1.createStatement();
			st.execute("update student set username = '" + username
					+ "' where id = " + id);
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
