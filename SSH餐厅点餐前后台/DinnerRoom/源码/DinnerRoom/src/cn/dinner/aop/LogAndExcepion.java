package cn.dinner.aop;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class LogAndExcepion {
	private static final Logger logger = Logger.getLogger(LogAndExcepion.class);
	//前置增强
	public void before(JoinPoint jp){
		logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()
				+"方法，方法入参："+Arrays.toString(jp.getArgs()));
	}
	//后置增强
	public void afterReturing(JoinPoint jp,Object result){
		logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()
				+"方法，方法返回值："+result);
	}
	//异常增强
	public void afterThrowing(JoinPoint jp,RuntimeException e) {
		logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()
				+"方法发生异常："+ e);
	}
}
