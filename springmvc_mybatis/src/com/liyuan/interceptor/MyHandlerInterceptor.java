package com.liyuan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 自定义拦截器
 * 拦截器实现原理：基于AOP（切面）*/

public class MyHandlerInterceptor implements HandlerInterceptor{

	//进入handler之前
		//应用场景：用于身份认证和身份授权
		//比如身份认证：如果认证不通过，需要此方法拦截
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
				Object handler) throws Exception {
			// TODO Auto-generated method stub
			//return false表示拦截，不向下执行
			//return true表示放行
			System.out.println("before");
			return true;
		}
	 
		//进入handler之后，返回modelAndView之前
		//应用场景：从ModelAndView触发：将公用的模型数据在这里传到视图，也可以在这里统一指定视图
		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response,
				Object handler, ModelAndView modelAndView) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("doing");
		}
	 
		//执行Handler完成之后执行
		//应用场景：统一的异常处理、统一日志处理
		@Override
		public void afterCompletion(HttpServletRequest request,
				HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
			// TODO Auto-generated method stub
			System.out.println("after");
		}

}
