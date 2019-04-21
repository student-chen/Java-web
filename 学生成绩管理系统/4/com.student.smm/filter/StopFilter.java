package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class StopFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String[] notFilter = new String[] { "login.jsp", "servletId" }; 
		String uri = request.getRequestURI();

		if (uri.indexOf("SurperMarket") != -1) {
			
			boolean doFilter = true;
			for (String s : notFilter) {
				if (uri.indexOf(s) != -1) {
					doFilter = false;
					break;
				}
			}
			if (doFilter) {  
                Object obj = request.getSession().getAttribute("suser");  
                if (null == obj) {  
                	response.setContentType("text/html;charset=utf-8");
                    request.setCharacterEncoding("UTF-8");  
                    PrintWriter out = response.getWriter();  
                    String loginPage = "login.jsp";  
                    StringBuilder builder = new StringBuilder();  
                    builder.append("<script type=\"text/javascript\">");  
                    builder.append("alert('«Î ‰»Î’À∫≈√‹¬Î');");  
                    builder.append("window.top.location.href='");  
                    builder.append(loginPage);  
                    builder.append("';");  
                    builder.append("</script>");  
                    out.print(builder.toString());  
                    out.flush();
            		out.close();
                } else {   
                    filterChain.doFilter(request, response);  
                }  
            } else {  
                filterChain.doFilter(request, response);  
            }  
		} else {  
            filterChain.doFilter(request, response);  
        }  
	}

}
