package com.bjpowernode.common.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bjpowernode.system.entity.base.UserEntity;
import com.bjpowernode.system.manager.ClientManager;
import com.bjpowernode.system.vo.Client;

/**
 * 获取资源工具类
 * @author Administrator
 *
 */
public class ResourceUtil {
	
	/**
	 * 获得请求路径
	 * 
	 * @param request
	 * @return
	 */
	public static String getRequestPath(HttpServletRequest request) {
		String requestPath = request.getRequestURI() + "?" + request.getQueryString();
		if (requestPath.indexOf("&") > -1) {// 去掉其他参数
			requestPath = requestPath.substring(0, requestPath.indexOf("&"));
		}
		requestPath = requestPath.substring(request.getContextPath().length() + 1);// 去掉项目路径
		return requestPath;
	}
	
	/**
	 * 获取登录用户IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.equals("0:0:0:0:0:0:0:1")) {
			ip = "本地";
		}
		return ip;
	}
	
	/**
	 * 获得用户信息
	 * @return
	 */
	public static final UserEntity getSessionUser() {
		HttpSession session = ContextHolderUtils.getSession();
		if(ClientManager.getInstance().getClient(session.getId())!=null){
			return ClientManager.getInstance().getClient(session.getId()).getUser();
		}
		return null;
	}
	
	/**
	 * 获得在线用户
	 * @return
	 */
	public static final Client getClient() {
		HttpSession session = ContextHolderUtils.getSession();
		if(ClientManager.getInstance().getClient(session.getId())!=null){
			return ClientManager.getInstance().getClient(session.getId());
		}
		return null;
	}
	
	/**
	 * 获取参数真正类型
	 * 
	 * @return
	 */
	public static Class getActualClass(Class clazz, int index) {
		Type type = clazz.getGenericSuperclass();
		if (!(type instanceof ParameterizedType)) {
			return getActualClass(clazz.getSuperclass(), index);
		}
		Type[] types = ((ParameterizedType) type).getActualTypeArguments();
		if (index >= types.length || index < 0) {
			return Object.class;
		}
		if (types[index] instanceof Class) {
			return (Class) types[index];
		}
		return Object.class;
	}
}
