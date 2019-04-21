package interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.student.pojo.UserOA;



public class StopLoginInterceptor implements HandlerInterceptor {
	
	private List<String> excludeURIS;//白名单：未登录的情况下允许访问
	public List<String> getExcludeURIS() {
		return excludeURIS;
	}

	public void setExcludeURIS(List<String> excludeURIS) {
		this.excludeURIS = excludeURIS;
	}
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		boolean isok = false;
		//1.获得请求的uri
		String baseuri=request.getRequestURI();
		String projecturi = request.getContextPath();
		String uri = baseuri.replace(projecturi, "");
		
		//2.请求URI是否在白名单中，是则放行，否则判断并拦截
		if(this.excludeURIS.contains(uri)){
			isok = true;
		}else{
		//3.判断session内置对象中是否在suserK-V
			HttpSession session = request.getSession();
			UserOA user= session.getAttribute("userOA")==null?null:(UserOA)session.getAttribute("userOA");
		    if(user != null){
		    	isok = true;
		    }else{
		    	//放置“提示信息”
		    	session.setAttribute("errmsg", "会话异常，请重新登录！");
		    	response.sendRedirect(request.getContextPath()+"/login.jsp");
		    }
		}
			return isok;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {	
	}
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}

}

