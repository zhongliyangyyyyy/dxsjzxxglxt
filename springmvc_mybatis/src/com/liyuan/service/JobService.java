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
	
	/**
	 * 获取有效职位列表
	 * @param request
	 * @return
	 */
	public JSONObject yxJob(HttpServletRequest request);
	
	/**
	 * 获取有效职位列表
	 * @param request
	 * @return
	 */
	public JSONObject wxJob(HttpServletRequest request);
	
	
	/**
	 * 下线职位
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject xxJob(String param,HttpServletRequest request);
	
	/**
	 * 上线职位
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject sxJob(String param,HttpServletRequest request);
	
	/**
	 * 删除职位
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject scJob(String param,HttpServletRequest request);
	
	/**
	 * 我收藏的职位
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject wscJob(String param,HttpServletRequest request);
	
	/**
	 * 收藏职位按钮
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject wyscJob(String param,HttpServletRequest request);
	
	/**
	 * 取消收藏按钮
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject qxscJob(String param,HttpServletRequest request);
	
	/**
	 * 投个简历
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject tgjl(String param,HttpServletRequest request);
}
