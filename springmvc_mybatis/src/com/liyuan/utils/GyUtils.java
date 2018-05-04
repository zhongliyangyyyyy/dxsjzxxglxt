package com.liyuan.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import Decoder.BASE64Decoder;
import net.sf.json.JSONObject;

public class GyUtils {
	
	/**
	 * 返回前端json数据
	 * @param success
	 * @param message
	 * @param result
	 * @return
	 */
	public static JSONObject returnResult(Boolean success,String message,JSONObject result){
		JSONObject data=new JSONObject();
		data.put("success", success);
		data.put("message", message);
		data.put("result", result);
		return data;
	}
	
	/**
	 * 获取uuid
	 * @return
	 */
	public static String getUUid(){
		String uuid=UUID.randomUUID().toString();
		return uuid.replace("-", "");
	}
	
	/**
	 * 将string类型转换为date类型
	 * @param date
	 * @return
	 */
	public static Date stringTodate(String date){
		if(date==null){
			return null;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			return simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println(e);
			return null;
		}
	}
	
	/**
	 * 将date类型转为string类型
	 * @param date
	 * @return
	 */
	public static String dateTostring(Date date){
		if(date==null){
			return null;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return simpleDateFormat.format(date);
	}
	
	public static String dateTostring2(Date date){
		if(date==null){
			return null;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		return simpleDateFormat.format(date);
	}
	
	/** 
     * 将base64字符解码保存文件 
     *  
     * @param base64Code 
     * @param targetPath 
     * @throws Exception 
     */  
  
    public static void decoderBase64File(String base64Code, String targetPath) {  
        byte[] buffer;  
        FileOutputStream out = null;  
        try {  
            buffer = new BASE64Decoder().decodeBuffer(base64Code);  
            out = new FileOutputStream(targetPath);  
            out.write(buffer);  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (out != null) {  
                    out.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}
