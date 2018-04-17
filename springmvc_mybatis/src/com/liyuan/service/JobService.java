package com.liyuan.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

public interface JobService {
	/**
	 * 获取职位种类列表
	 * @return
	 */
	public JSONObject getJobtype(); 
	
	/**
	 * 创建职位
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject creatJob(JSONObject param, HttpServletRequest request);
	
	/**
	 * 查看职位
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject ckJob(JSONObject param, HttpServletRequest request);
	
	/**
	 * 获取热门职位列表
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject hotJob(HttpServletRequest request);
	
	/**
	 * 获取最新职位列表
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject newJob(HttpServletRequest request);
	
	/**
	 * 搜索-表头过滤
	 * @param param
	 * @param request
	 * @return
	 */
	public  JSONObject searchJob(JSONObject param,HttpServletRequest request); 
}
