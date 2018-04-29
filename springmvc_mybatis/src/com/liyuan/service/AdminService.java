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
	
	/**
	 * 删除审核信息
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject scshxxService(String param,HttpServletRequest request);
	
	/**
	 * 待处理举报
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject dcljbService(String param,HttpServletRequest request);
	
	/**
	 * 已处理举报
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject ycljbService(String param,HttpServletRequest request);
	
	/**
	 * 拉黑
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject lhService(String param,HttpServletRequest request);
	
	/**
	 * 不予受理
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject byslService(String param,HttpServletRequest request);
	
	/**
	 * 删除举报信息
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject scjbxxService(String param,HttpServletRequest request);
	
	/**
	 * 获取黑名单列表
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject blackListService(String param,HttpServletRequest request);
	
	/**
	 * 恢复用户
	 * @param param
	 * @param request
	 * @return
	 */
	public JSONObject hfyhService(String param,HttpServletRequest request);
}
