package com.liyuan.service;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;


public interface LoginService {
	//登录验证
	JSONObject logIN(String email,String password, HttpServletRequest request);
}
