package com.liyuan.service;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

public interface UserInfoService {

	public JSONObject bcGrxx(String param,HttpServletRequest request);
	
	public  JSONObject bjGrxx(String param,HttpServletRequest request);
	
	public  JSONObject pl(String param,HttpServletRequest request);
	
	public JSONObject sdpl(String param,HttpServletRequest request);
	
	public JSONObject tjzw(String param,HttpServletRequest request);
}
