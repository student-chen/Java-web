package data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class adlist extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		Connection conn = null;
		Statement st = null;
		try {
			List<user> users = new ArrayList<user>();
			conn = link.getConnection();
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from user");// ??
			while (rs.next()) {
				user usr = new user();
				usr.setId(rs.getInt("id"));
				usr.setUsername(rs.getString("username"));
				usr.setPassword(rs.getString("password"));
				usr.setType(rs.getString("type"));
				users.add(usr);
			}
			request.setAttribute("users", users);
			request.getRequestDispatcher("adlist.jsp").forward(request,
					response);
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

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { // 处理post请求
		this.doGet(req, resp); // 同一种方法体处理
	}

}
