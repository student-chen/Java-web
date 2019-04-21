package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tsinghuait.st0717.hospitalsystem.service.LoginService;
import javax.swing.JOptionPane;

public class LoginServlet extends HttpServlet{
	/*
	 *  对登录进行判断
	 * */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("gbk");
		arg1.setCharacterEncoding("gbk");
		String username=arg0.getParameter("username");
		String password=arg0.getParameter("password");
		String postOffice=arg0.getParameter("postOffice");
		System.out.println("username:"+username+"\n password:"+password+"\n postOffice:"+postOffice);
		String sql="";
		if(postOffice.equals("医生")||postOffice==null||postOffice==""||postOffice=="医生"){
			sql="select * from doctor where loginName='"+username+"' and loginPassword='"+password+"'";
			LoginService loginService=new LoginService();
			ResultSet rs=loginService.loginSelect(sql);
			if(rs!=null){
				String maName=loginService.selectDoctorMcName(sql);
				arg0.getSession().setAttribute("doctorLoginTree",maName);//医生登录后判断它的病人和他的科室
				System.out.println("session_loginDoctor:"+arg0.getSession().getAttribute("doctorLoginTree"));
				arg0.getSession().setAttribute("doctorName",username);
				arg0.getSession().setAttribute("doctorPassword",password);
				arg0.getRequestDispatcher("/mainDoctor.jsp").forward(arg0, arg1);
				return;
			}else{
				JOptionPane.showMessageDialog(null,"医生登录失败,请检查您填写的信息是否正确!!");
				arg0.getRequestDispatcher("/login.jsp").forward(arg0, arg1);
				return ;
			}
		}
		else if(postOffice=="护士"||postOffice.equals("护士")){
			sql="select *from nurse where loginName='"+username+"' and loginPassword='"+password+"'";
			LoginService loginService=new LoginService();
			ResultSet rs=loginService.loginSelect(sql);
			if(rs!=null){
				String maName=loginService.seleceNursePost(sql);
				arg0.getSession().setAttribute("nurseLoginTree",maName);//护士登录后判断它的病人和他的科室
				System.out.println("session_loginNurse:"+arg0.getSession().getAttribute("nurseLoginTree"));	
				arg0.getSession().setAttribute("nurseName",username);
				arg0.getSession().setAttribute("nursePassword",password);
				arg0.getRequestDispatcher("/mainNurse.jsp").forward(arg0, arg1);
				return ;
			}else{
				JOptionPane.showMessageDialog(null,"护士登录失败,请检查您填写的信息是否正确!!!");
				arg0.getRequestDispatcher("/login.jsp").forward(arg0, arg1);
				return ;
			}
		}
		else if(postOffice=="管理员"||postOffice.equals("管理员")){
			if((username.equals("管理员")||username=="管理员")&&(password=="123"||password.equals("123"))){
				arg0.getRequestDispatcher("/main.jsp").forward(arg0, arg1);
				return ;
			}else{
				JOptionPane.showMessageDialog(null,"管理员登录失败,请检查您填写的信息是否正确!!!");
				arg0.getRequestDispatcher("/login.jsp").forward(arg0, arg1);
				return ;
			}
		}else{
			JOptionPane.showMessageDialog(null,"登录失败!!!");
			arg0.getRequestDispatcher("/h").forward(arg0, arg1);
			return ;
		}
	}
	public void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		this.doGet(arg0, arg1);
	}	
}