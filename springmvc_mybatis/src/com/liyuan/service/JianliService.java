package com.liyuan.service;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

public interface JianliService {
	
	
	public JSONObject personJianli(HttpServletRequest request);
	
	public JSONObject bcJianli(String param,HttpServletRequest request);
	
	public JSONObject dclJianli(String param,HttpServletRequest request);
	
	public JSONObject ddJianli(String param,HttpServletRequest request);
	
	public JSONObject ytzmsJianli(String param,HttpServletRequest request);
	
	public JSONObject bhsJianli(String param,HttpServletRequest request);
	
	public JSONObject tgmsJianli(String param,HttpServletRequest request);
	
	/**
	 * 设置为不合适状态
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject setBhs(String param,HttpServletRequest request);
	
	/**
	 * 设置为待定状态
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject setDd(String param,HttpServletRequest request);
	
	/**
	 * 删除收到的简历
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject deletJl(String param,HttpServletRequest request);
	
	/**
	 * 设置为通知面试状态
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject setTzms(String param,HttpServletRequest request);
	
	/**
	 * 设置为通过面试状态
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject setTgms(String param,HttpServletRequest request);
}
