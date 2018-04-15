package com.liyuan.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyuan.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject logIN(@RequestBody String params, HttpServletRequest request){
		JSONObject jsonParam=JSONObject.fromObject(params);
		String email=jsonParam.getString("email");
		String password=jsonParam.getString("password");
		return loginService.logIN(email, password,request);
	}
}
