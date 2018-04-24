package com.liyuan.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserInfoController {
	
	/**
	 * 保存个人信息
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/bcgrxx", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject bcGrxx(@RequestBody String param,HttpServletRequest request){
		return null;
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
		return null;
	}
}
