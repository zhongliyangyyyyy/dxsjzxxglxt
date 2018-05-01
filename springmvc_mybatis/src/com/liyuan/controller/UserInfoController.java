package com.liyuan.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyuan.service.UserInfoService;

@Controller
public class UserInfoController {
	@Autowired
	UserInfoService userService;
	
	/**
	 * 保存个人信息
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/bcgrxx", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject bcGrxx(@RequestBody String param,HttpServletRequest request){
		return userService.bcGrxx(param, request);
	}
	
	/**
	 * 编辑个人信息
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/bjgrxx", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject bjGrxx(@RequestBody String param,HttpServletRequest request){
		return userService.bjGrxx(param, request);
	}
}
