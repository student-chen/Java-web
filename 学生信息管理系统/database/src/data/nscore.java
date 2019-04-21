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

public class nscore extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");

		Connection conn = null;
		Statement st = null;
		Connection conn1 = null;
		Statement st1 = null;

		try {
			List<course> cs = new ArrayList<course>();
			conn1 = link.getConnection();
			st1 = conn1.createStatement();
			String teacher=request.getSession().getAttribute("name").toString();
			ResultSet rs1 = st1.executeQuery("select * from course where teacher='"+teacher+"'");

			while (rs1.next()) {
				course crs = new course();
				crs.setCourse(rs1.getString("course"));
				cs.add(crs);
			}

			List<student> stu = new ArrayList<student>();
			conn = link.getConnection();
			st = conn.createStatement();
			String s;
			ResultSet rs = st.executeQuery("select * from student");
			while (rs.next()) {
				student std = new student();
				std.setId(rs.getInt("id"));
				std.setUsername(rs.getString("username"));
				for (course crs : cs) {
					s = crs.getCourse();
					std.setScore(rs.getInt(s));
					std.setCourse(s);
				}
				stu.add(std);
			}
			request.setAttribute("course", cs);
			request.setAttribute("student", stu);
			request.getRequestDispatcher("nscore.jsp").forward(request,
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
			throws ServletException, IOException { 

		Connection conn = null;
		Statement st = null;
		Connection conn1 = null;
		Statement st1 = null;
		try {
			List<course> cs = new ArrayList<course>();
			conn1 = link.getConnection();
			st1 = conn1.createStatement();
			String teacher=req.getSession().getAttribute("name").toString();
			ResultSet rs1 = st1.executeQuery("select * from course where teacher='"+teacher+"'");

			while (rs1.next()) {
				course crs = new course();
				crs.setCourse(rs1.getString("course"));
				cs.add(crs);
			}

			List<student> stu = new ArrayList<student>();
			conn = link.getConnection();
			st = conn.createStatement();
			String s;
			ResultSet rs = st.executeQuery("select * from student");
			while (rs.next()) {
				student std = new student();
				std.setId(rs.getInt("id"));
				std.setUsername(rs.getString("username"));
				for (course crs : cs) {
					s = crs.getCourse();
					std.setScore(rs.getInt(s));
					std.setCourse(s);
				}
				stu.add(std);
			}
			for (student std : stu){
				for(int j=0;j<cs.size();j++){
					Connection conn2 = link.getConnection();
					Statement st2 = conn2.createStatement();
					String str=req.getParameter("score["+std.getId()+"]["+j+"]");
					int sco=Integer.parseInt(str);
					if(!(sco>=0&&sco<=100))
						sco=0;
					String c = std.getCourse()[j];
					st2.execute("update student set "+c+" = '" + sco + "' where id = " + std.getId());
					st2.close();
				}
			}
			resp.sendRedirect("tclist");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
