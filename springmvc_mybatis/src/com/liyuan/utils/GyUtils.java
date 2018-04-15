package com.liyuan.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	public static Date stringTodate(String date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			return simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println(e);
			return null;
		}
	}
	
	public static String dateTostring(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return simpleDateFormat.format(date);
	}
	
}
