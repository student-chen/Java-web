package com.tsinghuait.st0717.hospitalsystem.servlet;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServltes extends HttpServlet {	
	private final static int SAVE=0;//便历
	private final static int INSERT=1;	//添加
	private final static int DELETE=2;//删除
	private final static int UPDATE=3;//修改
	private final static int SELECT=4;//查看	
	public void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		this.doGet(arg0, arg1);
	}	
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String opertion=arg0.getParameter("opertion");
		int opertionInt=0;
		if(opertion!=null){
			opertionInt=Integer.parseInt(opertion);
		}
		System.out.println("opertion:"+opertion);
		RequestDispatcher rd=null;
		switch(opertionInt){
			case SAVE:rd=executeQuery(arg0, arg1); break;
			case INSERT: rd=insert(arg0, arg1);break;
			case DELETE:rd=delete(arg0, arg1); break;
			case UPDATE:rd=update(arg0, arg1);break;
			case SELECT:rd=select(arg0, arg1);break;
			default:rd=executeQuery(arg0, arg1);break;
		}		
		rd.forward(arg0, arg1);
	}
	//便历数据库中的信息sert
	protected abstract RequestDispatcher executeQuery(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException;
	//添加信息
	protected abstract RequestDispatcher insert(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException;
	//删除信息
	protected abstract RequestDispatcher delete(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException;
	//修改信息
	protected abstract RequestDispatcher update(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException;
	//查看信息
	protected abstract RequestDispatcher select(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException;
	protected String getParamByMyFilter(HttpServletRequest request,String paramKey){
		String target = request.getParameter(paramKey);
		//System.out.println(request.getMethod());
		if (request.getMethod().equalsIgnoreCase("post")){
			return target == null ? "" : target;
		} else {
			try {
				return target == null ? "" : new String (target.getBytes("ISO-8859-1"),"GBK");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return target;
	}
}
