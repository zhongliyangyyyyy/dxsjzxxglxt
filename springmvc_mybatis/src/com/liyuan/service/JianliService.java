package com.liyuan.service;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

public interface JianliService {
	
	/**
	 * 获取简历信息
	 * @param request
	 * @return
	 */
	public JSONObject personJianli(HttpServletRequest request);
	
	/**
	 * 保存简历
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject bcJianli(String param,HttpServletRequest request);
	
	/**
	 * 待处理简历
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject dclJianli(String param,HttpServletRequest request);
	
	/**
	 * 待定简历
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject ddJianli(String param,HttpServletRequest request);
	
	/**
	 * 已通知面试简历
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject ytzmsJianli(String param,HttpServletRequest request);
	
	/**
	 * 不合适简历
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject bhsJianli(String param,HttpServletRequest request);
	
	/**
	 * 通过面试简历
	 * @param param
	 * @param request
	 * @return
	 */
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
	
	
	/**
	 * 获取已投递简历列表
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject ytdJianli(String param,HttpServletRequest request);
	
	/**
	 * 投递简历
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject tdJianli(String param,HttpServletRequest request);
	
	/**
	 * 查看简历
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject ckJianli(String param,HttpServletRequest request);
	
	/**
	 * 投递简历统计
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject tdjltj(String param,HttpServletRequest request);
}
