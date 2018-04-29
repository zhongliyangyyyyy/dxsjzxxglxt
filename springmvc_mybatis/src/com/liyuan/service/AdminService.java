package com.liyuan.service;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

public interface AdminService {
	
	/**
	 * 待审核列表
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject dshlbService(String param,HttpServletRequest request);
	
	/**
	 * 已审核列表
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject yshlbService(String param,HttpServletRequest request);
	
	/**
	 * 审核通过
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject shtgService(String param,HttpServletRequest request);
	
	/**
	 * 审核不通过
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject shbtgService(String param,HttpServletRequest request);
	
}
