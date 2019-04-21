package filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.pojo.UserOA;


public class StopJSPFilter implements Filter {
private List<String> excludeJSP;//白名单：未登录的情况下允许访问
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
				
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		//1.获得请求的uri
		String baseuri=request.getRequestURI();
		String projecturi = request.getContextPath();
		String uri = baseuri.replace(projecturi, "");
		
		if(this.excludeJSP.contains(uri)){
			chain.doFilter(arg0, arg1);
		}else{
			HttpSession session = request.getSession();
			UserOA users=session.getAttribute("userOA")==null?null:(UserOA)session.getAttribute("userOA");
		    if(users != null){
		    	chain.doFilter(arg0, arg1);
		    }else{
		    	//放置“提示信息”
		    	session.setAttribute("errmsg", "会话异常，请重新登录！!");
		    	response.sendRedirect(projecturi+"/login.jsp");
		    }
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		//完成“白名单”的赋值
		String excludes = filterConfig.getInitParameter("excludes");
		if(excludes !=null && excludes.length()>0){
			String[] excludesArray = excludes.split(";");
			this.excludeJSP = Arrays.asList(excludesArray);
		}
	}

}
