package msc.util;



import java.io.*;
import javax.servlet.*;


public class EncodingFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (Exception e) {
		}

		chain.doFilter(request, response);
	}

	public void destroy() {

	}
}
