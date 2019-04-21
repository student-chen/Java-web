package cn.dinner.Interceptor;

import java.util.Map;

import cn.dinner.entity.Users;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map session = invocation.getInvocationContext().getSession();
		Users user = (Users)session.get("user");
		if(user==null){
			return Action.LOGIN;
		}else{
			return invocation.invoke();
		}
	}

}
