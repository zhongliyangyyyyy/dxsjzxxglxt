package com.liyuan.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyuan.service.TestService;

@Controller
public class TestController {
@Autowired TestService testService;

	/*@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public JSONObject Test(@RequestParam("account") String account,@RequestParam("password") String password){
		return testService.person(account,password);
	}*/
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject Test(@RequestBody String params){
		JSONObject data1=JSONObject.fromObject(params);
		System.out.println(data1.getString("account"));
		System.out.println(data1.getString("password"));
		JSONObject data=new JSONObject();
		data.put("name", "钟黎阳");
		data.put("age", 18);
		return data;
	}
}
