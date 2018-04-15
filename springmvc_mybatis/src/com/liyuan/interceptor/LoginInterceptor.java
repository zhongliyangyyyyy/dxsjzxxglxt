﻿package com.liyuan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
/*		// 获取请求的url
		String url = request.getRequestURI();
		// 判断url是否是公开 地址（实际使用时将公开 地址配置配置文件中）
		// 这里公开地址是登陆提交的地址
		if (url.contains("login")||url.contains("register")) {
			// 如果进行登陆提交，放行
			return true;
		}
		// 判断session
		HttpSession session = request.getSession();
		// 从session中取出用户身份信息
		String email = (String) session.getAttribute("email");
		if (email != null) {
			// 身份存在，放行
			return true;
		}
		// 执行这里表示用户身份需要认证，跳转登陆页面
		request.getRequestDispatcher("/login.html").forward(request,
				response);
		return false;*/
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
