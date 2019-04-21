package data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class delete extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement st = null;
		Connection conn1 = null;
		Statement st1 = null;
		try {
			conn = link.getConnection();
			st = conn.createStatement();
			String id = request.getParameter("id");
			st.execute("delete from user where id = " + id);
			conn1 = link.getConnection();
			st1 = conn1.createStatement();
			st1.execute("delete from student where id = " + id);
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
