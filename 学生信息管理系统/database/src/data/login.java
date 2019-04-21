package data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		Connection conn = null;
		Statement st = null;
		try {
			conn = link.getConnection();
			st = conn.createStatement();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			request.getSession().setAttribute("type","0");
			request.getSession().setAttribute("name",username);
			int id;
			String type;

			PreparedStatement pstmt = conn.prepareStatement("select * from user where userName=?");
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				request.getSession().setAttribute("username",username);
				request.getSession().setAttribute("password",password);
				if (password.equals(rs.getString("password"))) {
					id = rs.getInt("id");
					request.getSession().setAttribute("id",id);
					type = rs.getString("type");
					request.getSession().setAttribute("type",type);
					if (type.equals("2")) {
						response.sendRedirect("tclist?id="+id);
						return;
					}
					if (type.equals("1")) {
						response.sendRedirect("stlist?id="+id);
						return;
					}
					if (type.equals("3")) {
						response.sendRedirect("adlist?id="+id);
						return;
					}
				}
			}
			response.sendRedirect("login.jsp");
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
