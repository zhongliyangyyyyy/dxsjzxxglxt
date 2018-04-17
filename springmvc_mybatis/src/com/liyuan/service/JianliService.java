package com.liyuan.service;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

public interface JianliService {
	
	
	public JSONObject personJianli(String param,HttpServletRequest request);
	
}
