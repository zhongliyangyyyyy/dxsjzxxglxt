package com.liyuan.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyuan.service.JianliService;

@Controller
public class JianliController {
	
	@Autowired JianliService jianliService;
	
	/**
	 * 查看，编辑简历
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/ckjianli", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject ckJianli(HttpServletRequest request){
		return jianliService.personJianli(request);
	}
	
	/**
	 * 保存简历
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/bcjianli", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject bcJianli(@RequestBody String param,HttpServletRequest request){
		return jianliService.bcJianli(param, request);
	}
	
}	 
