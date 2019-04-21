package com.sevenEleven.servlet;

// ==================== Program Discription =====================
	// ������ƣ�ʾ��14-8 : LoginFilter.java
	// ����Ŀ�ģ�ѧϰʹ�õ�¼������
	// ==============================================================
	import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

	public class LoginFilter implements Filter
	{
		static String LOGIN_PAGE="index.jsp";
		static String ERR_Page="../error500.jsp";
		protected FilterConfig filterConfig;
 
		public void doFilter(final ServletRequest req,final ServletResponse 
res,FilterChain chain)throws IOException,ServletException
		{
		 HttpServletRequest hreq = (HttpServletRequest)req;
	
	         String isLog=(String)hreq.getSession().getAttribute("isLog");	 
 if((isLog!=null)&&((isLog.equals("true"))||(isLog=="true")))
			 {
			 	chain.doFilter(req,res);
			 	return ;
			 }
			 else{
				 hreq.getRequestDispatcher(ERR_Page).forward(req, res);
				
			 }
			 	
		}
		
		public void destroy()
		{
			this.filterConfig=null;
		}
		public void init(FilterConfig config)
		{
			this.filterConfig=config;
		}
		public void setFilterConfig(final FilterConfig filterConfig)
		{
			this.filterConfig=filterConfig;
		}	
	}