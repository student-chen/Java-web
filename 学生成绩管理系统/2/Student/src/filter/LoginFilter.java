package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter
{
	public void destroy()
	{
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		// 如果还没有登录的话跳回登录页面
		String isLogin = (String) ((HttpServletRequest) request).getSession().getAttribute("isLogin");
		
		if (isLogin == null || isLogin.equals(""))
			((HttpServletResponse) response).sendRedirect("/Student/login.jsp");
		else
			chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException
	{
	}
}
