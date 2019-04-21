package com.tsinghuait.st0717.hospitalsystem.fitler;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ChineseFilterGBK implements Filter{
	private FilterConfig filterConfig;
	private String coding="";
    public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig=filterConfig;
		this.coding=filterConfig.getInitParameter("encoding");
	}	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			HttpServletRequest hsr=(HttpServletRequest)request;
			hsr.setCharacterEncoding(coding);
			chain.doFilter(request, response);
		} catch (RuntimeException e) {			
			e.printStackTrace();
			filterConfig.getServletContext().log(e.getMessage());
		}
	}
   public void destroy() {
		this.filterConfig=null;		
	}
}
