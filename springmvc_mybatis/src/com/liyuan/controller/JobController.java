package com.liyuan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.catalina.ssi.SSICommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyuan.service.JobService;

@Controller
public class JobController {
	
	@Autowired
	JobService jobservice;
	
	@RequestMapping(value="/jobtype",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getJobtype(){
		return jobservice.getJobtype();
	}
	
	@RequestMapping(value="/creatjob",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject creatJob(@RequestBody String param, HttpServletRequest request){
		JSONObject  jsonparam=JSONObject.fromObject(param);
		return jobservice.creatJob(jsonparam,request);
	}
	
	@RequestMapping(value="/ckjob",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject ckJob(@RequestBody String param,  HttpServletRequest request){
		JSONObject  jsonparam=JSONObject.fromObject(param);
		return jobservice.ckJob(jsonparam,request);
	}
}
