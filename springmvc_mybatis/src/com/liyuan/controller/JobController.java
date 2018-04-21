package com.liyuan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;
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
	
	/**
	 * 职位种类
	 * @return
	 */
	@RequestMapping(value="/jobtype",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getJobtype(){
		return jobservice.getJobtype();
	}
	
	/**
	 * 创建职位
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/creatjob",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject creatJob(@RequestBody String param, HttpServletRequest request){
		JSONObject  jsonparam=JSONObject.fromObject(param);
		return jobservice.creatJob(jsonparam,request);
	}
	
	/**
	 * 查看职位,跟编辑用同一个接口
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/ckjob",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject ckJob(@RequestBody String param,  HttpServletRequest request){
		JSONObject  jsonparam=JSONObject.fromObject(param);
		return jobservice.ckJob(jsonparam,request);
	}
	
	/**
	 * 获取最热职位列表
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/hotjob",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject hotJob(HttpServletRequest request){
		
		return jobservice.hotJob( request);
	}
	
	/**
	 * 获取最新职位列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/newjob",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject newJob(HttpServletRequest request){
		
		return jobservice.newJob(request);
	}
	
	/**
	 * 搜索职位，跟表头过滤用一个
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/searchjob",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject searchJob(@RequestBody String param,  HttpServletRequest request){
		JSONObject  jsonparam=JSONObject.fromObject(param);
		return jobservice.searchJob(jsonparam,request);
	}
	
	/**
	 * 获取有效职位列表
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/yxjob",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject yxJob(HttpServletRequest request){
		return jobservice.yxJob(request);
	}
	
	/**
	 * 获取无效职位列表
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/wxjob",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject wxJob(HttpServletRequest request){
		return jobservice.wxJob(request);
	}
	
	/**
	 * 下线职位
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/xxjob",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject yxJob(@RequestBody String param,HttpServletRequest request){
		return jobservice.xxJob(param,request);
	}
	
	/**
	 * 上线职位
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/sxjob",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject sxJob(@RequestBody String param,HttpServletRequest request){
		return jobservice.sxJob(param,request);
	}
	
	/**
	 * 删除职位
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/deletejob",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject scJob(@RequestBody String param,HttpServletRequest request){
		return jobservice.scJob(param,request);
	}
	
	
	/**
	 * 我收藏的职位
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/wscjob",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject wscJob(@RequestBody String param,HttpServletRequest request){
		return jobservice.wscJob(param, request);
	}
	
	/**
	 * 收藏职位
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/wyscjob",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject wyscJob(@RequestBody String param,HttpServletRequest request){
		return jobservice.wyscJob(param, request);
	}
	
	/**
	 * 删除收藏职位
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/qxscjob",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject qxscJob(@RequestBody String param,HttpServletRequest request){
		return jobservice.qxscJob(param, request);
	}
}
