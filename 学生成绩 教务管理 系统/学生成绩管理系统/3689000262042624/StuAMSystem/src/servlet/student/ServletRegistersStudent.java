package servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.StudentServiceImpl;
import service.Impl.UserServiceImpl;

import model.Student;
import model.User;

public class ServletRegistersStudent extends HttpServlet{
	
	private User user;
	private Student student;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	private StudentServiceImpl studentServiceImpl =new StudentServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
		
			int rsUser=userServiceImpl.addUser(user);
			int rsStu=studentServiceImpl.addStu(student);
			if(rsStu>0 && rsUser>0){
				request.setAttribute("massage", "×¢²á³É¹¦£¡£¡");
				request.getRequestDispatcher("login/login.jsp").forward(request, response);
				
			}else{
				request.setAttribute("msg", "×¢²áÊ§°Ü£¡£¡");
				request.getRequestDispatcher("register/register.jsp").forward(request, response);
			}
		
		
	}

}
