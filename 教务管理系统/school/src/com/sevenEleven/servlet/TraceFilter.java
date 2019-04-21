package com.sevenEleven.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Filter implementation class for Filter: TraceFilter
 * 
 */
public class TraceFilter implements Filter {
	@SuppressWarnings("unused")
	private ServletContext context;

	/**
	 * ��ʹ������
	 * 
	 * @param config
	 * @exception ServletException
	 */
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		context = config.getServletContext();
	}

	/**
	 * Filter ������
	 * 
	 * @param request
	 * @param response
	 * @param chain
	 * @exception ServletException,IOException
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		((HttpServletRequest) request).setCharacterEncoding("gb2312");
		chain.doFilter(request, response);
	}

	/**
	 * destroy����
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

}