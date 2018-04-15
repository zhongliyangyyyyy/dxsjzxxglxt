package com.liyuan.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyuan.service.RegisterService;

@Controller
public class RegisterController {
	@Autowired
	RegisterService regService;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject register(@RequestBody String params){
		JSONObject jsonParam=JSONObject.fromObject(params);
		return regService.register(jsonParam);
	}

}
