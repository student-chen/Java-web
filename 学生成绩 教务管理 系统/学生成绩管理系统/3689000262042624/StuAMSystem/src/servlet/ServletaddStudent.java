package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.StudentServiceImpl;
import service.Impl.UserServiceImpl;

import model.Student;
import model.User;

public class ServletaddStudent extends HttpServlet {

	private User user;
	private Student student;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	private StudentServiceImpl studentServiceImpl =new StudentServiceImpl();
	private ServletFindAllStu findStu=new ServletFindAllStu();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stuNum = request.getParameter("stuNum");
		String stuName = request.getParameter("stuName");
		String pwd = request.getParameter("password");
		String stuSex = request.getParameter("stuSex");
		int stuAge = Integer.parseInt(request.getParameter("stuAge"));
		String stuClass = request.getParameter("stuClass");
		String major = request.getParameter("major");
		String department = request.getParameter("department");
		String phone = request.getParameter("phone");
		int roleID = Integer.parseInt(request.getParameter("role"));
		user = new User(stuNum, stuName, pwd, phone, roleID);
		student = new Student(stuNum, stuName, stuSex, stuAge, stuClass, major,
				department);
		//验证是否存在该学生
		User rs=userServiceImpl.login(user);
		if(rs.getUserID()==0){
			int rsUser=userServiceImpl.addUser(user);
			int rsStu=studentServiceImpl.addStu(student);
			if(rsStu>0 && rsUser>0){
				request.setAttribute("msg", "添加成功！！");
				findStu.doGet(request, response);
				
				/*List list=studentDaoImpl.findAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("admin/studentAllInfo.jsp").forward(request, response);*/
			}else{
				request.setAttribute("msg", "添加失败！！");
				request.getRequestDispatcher("admin/addStudent.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "该学号已存在，请重新录入！！");
			request.getRequestDispatcher("admin/addStudent.jsp").forward(request, response);
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
