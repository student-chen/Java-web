package com.offcn.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.offcn.pojo.Student;
import com.offcn.pojo.Teacher;
import com.offcn.pojo.User;
import com.offcn.service.StudentService;
import com.offcn.service.TeacherService;
import com.offcn.service.UserService;

@Controller
@RequestMapping("/admin")
public class UserController {

	@Resource
	UserService userService;
	
	@Resource
	StudentService studentService;
	
	@Resource
	TeacherService teacherService;
	
	@RequestMapping("/login")
	public String login(User user,Model model,HttpServletRequest req) {
		HttpSession session=req.getSession();
		int usertype=-1;
		if(user!=null){
		  usertype=user.getUsertype();
		  if(usertype==1){
			  //管理员
			 User loginuser= userService.userlogin(user);
			 if(loginuser!=null){
				 session.setAttribute("user", loginuser);
				 return "homepage/index";
			 }else{
				 model.addAttribute("msg", "请输入正确的用户名和密码");
				 return "/index";
			 }
		  }else if(usertype==2){
			  //学生
			  Student student=new Student();
			  student.setLoginname(user.getName());
			  student.setPassword(user.getPassword());
			  Student loginstu=studentService.stulogin(student);
			  if(loginstu!=null){
				  session.setAttribute("user", loginstu);
				  return "homepage/index";
			  }else{
				  model.addAttribute("msg", "请输入正确的用户名和密码");
				  return "/index";
			  }
			 
		  }else{
			 //老师 
			  Teacher tea=new Teacher();
			  tea.setLoginname(user.getName());
			  tea.setPassword(user.getPassword());
			  Teacher logintea=teacherService.loginTea(tea);
			  if(logintea!=null){
				  session.setAttribute("user", logintea);
				  return "homepage/index";
			  }else{
				  model.addAttribute("msg", "请输入正确的用户名和密码");
				  return "/index";
			  }
		  }
		  
		}
		return "homepage/index";
	}
	
	
	
	
}
