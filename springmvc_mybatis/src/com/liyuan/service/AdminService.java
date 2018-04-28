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
	
}
