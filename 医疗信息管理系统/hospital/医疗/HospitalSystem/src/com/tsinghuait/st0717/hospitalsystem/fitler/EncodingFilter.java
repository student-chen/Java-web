package com.tsinghuait.st0717.hospitalsystem.fitler;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String encoding="gbk";
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
	}

	public void init(FilterConfig config) throws ServletException {
		String encoding = config.getInitParameter("encoding");
		if (encoding != null){
			this.encoding = encoding;
		}
	}

}
