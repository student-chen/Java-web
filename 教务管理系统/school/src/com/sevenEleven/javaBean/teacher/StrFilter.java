package com.sevenEleven.javaBean.teacher;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StrFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
		

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		((HttpServletRequest)request).setCharacterEncoding("GB2312");
		((HttpServletResponse)response).setCharacterEncoding("GB2312");
		chain.doFilter(request,response);

	}

	public void destroy() {
		
	}

}
