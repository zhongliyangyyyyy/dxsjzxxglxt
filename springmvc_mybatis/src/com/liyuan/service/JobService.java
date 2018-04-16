package com.liyuan.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

public interface JobService {
	public JSONObject getJobtype(); 
	
	public JSONObject creatJob(JSONObject param, HttpServletRequest request);
	
	public JSONObject ckJob(JSONObject param, HttpServletRequest request);
}
