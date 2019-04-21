package com.svse.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.ArrayUtils;

public class LoginFilter implements Filter {

	private FilterConfig config;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();

		String a = request.getRequestURI();
		/*if(session.getAttribute("actionids")!=null){
			String ss=session.getAttribute("actionids").toString();
			System.out.println(ss);
			String[] strs=ss.split("、");
			if(ArrayUtils.contains(strs,"查询组织结构")){
				arg2.doFilter(arg0, arg1);
			}else{
				response.sendRedirect("../elimit.jsp");
			}
		}
		
		*/
		if (session.getAttribute("master") != null ||a.indexOf("/error.jsp") != -1 || a.indexOf("/master.do") != -1 || a.indexOf("/login.jsp") != -1
				|| a.contains(".css") || a.endsWith(".js") || a.contains(".png") || a.contains(".jpg")
				|| a.contains("fonts")) {
			arg2.doFilter(arg0, arg1);
			return;
		} else {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		config = arg0;
	}

}
