package com.liyuan.utils;

import java.util.UUID;

import net.sf.json.JSONObject;

public class GyUtils {
	public static JSONObject returnResult(Boolean success,String message,JSONObject result){
		JSONObject data=new JSONObject();
		data.put("success", success);
		data.put("message", message);
		data.put("result", result);
		return data;
	}
	
	public static String getUUid(){
		String uuid=UUID.randomUUID().toString();
		return uuid.replace("-", "");
	}
}
