package com.china.luanma;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;

public class SetEncodingFilter implements Filter
{
	public void init(FilterConfig config) throws ServletException {}

	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException
	{
		 request.setCharacterEncoding("GB2312");
		 chain.doFilter(request,response);
	}
	
	public void destroy() {}
	
}
