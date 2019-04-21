package servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.User;
import service.Impl.StudentServiceImpl;
import service.Impl.UserServiceImpl;
import servlet.ServletFindAllStu;
import dao.Impl.StudentDaoImpl;
import dao.Impl.UserDaoImpl;

public class ServletRegisterStu extends HttpServlet{
	
	private User user;
//	private Student student;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
//	private StudentServiceImpl studentServiceImpl =new StudentServiceImpl();
	//private ServletFindAllStu findStu=new ServletFindAllStu();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String stuNum = request.getParameter("stuNum");
		user=new User();
		user.setUserNum(stuNum);
		//验证是否存在该学生
		User rs=userServiceImpl.login(user);
		if(rs.getUserID()==0){
			out.print("正确");
			
		}else{
		
			out.print("该学号已存在");
			
		}
		
		
	}

}
