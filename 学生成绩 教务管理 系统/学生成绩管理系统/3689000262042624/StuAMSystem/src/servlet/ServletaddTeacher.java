package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.TeacherServiceImpl;
import service.Impl.UserServiceImpl;

import model.Teacher;
import model.User;
import dao.Impl.TeacherDaoImpl;
import dao.Impl.UserDaoImpl;

public class ServletaddTeacher extends HttpServlet{


	private User user;
	private Teacher teacher;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	private TeacherServiceImpl teacherServiceImpl =new TeacherServiceImpl();
	private ServletFindAllTea findTea=new ServletFindAllTea();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String teaNum = request.getParameter("teaNum");
		String teaName = request.getParameter("teaName");
		String pwd = request.getParameter("password");
		String teaSex = request.getParameter("teaSex");
		int teaAge = Integer.parseInt(request.getParameter("teaAge"));
		String teaCourse = request.getParameter("teaCourse");
		String major = request.getParameter("major");
		String department = request.getParameter("department");
		String phone = request.getParameter("phone");
		int roleID = Integer.parseInt(request.getParameter("role"));
		user = new User(teaNum, teaName, pwd, phone, roleID);
		teacher = new Teacher(teaNum, teaName, teaSex, teaAge, teaCourse, major,
				department);
		//验证是否存在该教师
		User rs=userServiceImpl.login(user);
		if(rs.getUserID()==0){
			int rsUser=userServiceImpl.addUser(user);
			int rsTea=teacherServiceImpl.addTea(teacher);
			if(rsTea>0 && rsUser>0){
				request.setAttribute("msg", "添加成功！！");
				findTea.doGet(request, response);
			//	request.getRequestDispatcher("admin/teacherAllInfo.jsp").forward(request, response);
				/*List list=studentDaoImpl.findAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("admin/studentAllInfo.jsp").forward(request, response);*/
			}else{
				request.setAttribute("msg", "添加失败！！");
				request.getRequestDispatcher("admin/addTeacher.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "该工号已存在，请重新录入！！");
			request.getRequestDispatcher("admin/addTeacher.jsp").forward(request, response);
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}
