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

public class LoginFilter implements Filter{

	public void destroy() {
		
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		// 获得在下面代码中要用的request,response,session对象
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		// 获得用户请求的URI
		String path=request.getRequestURI();
		String userNum = (String) request.getSession().getAttribute("usernum");
		  // 登陆页面无需过滤
		  if(path.indexOf("/login.jsp") > -1 || path.indexOf("/register.jsp")>-1) {
		   chain.doFilter(request, response);
		   return;
		  }
		  // 判断如果没有取到员工信息,就跳转到登陆页面
		  if (userNum == null || "".equals(userNum)) {
		   // 跳转到登陆页面
		   response.sendRedirect("/StuAMSystem/login/login.jsp");
		  } else {
			  
		   // 已经登陆,继续此次请求
		   chain.doFilter(request, response);
		  }
		
	}

	public void init(FilterConfig arg0) throws ServletException {
	
	}

}
