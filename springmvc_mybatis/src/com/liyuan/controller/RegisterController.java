package com.liyuan.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyuan.mapper.LoginMapper;
import com.liyuan.po.LoginEntity;
import com.liyuan.service.RegisterService;
import com.liyuan.utils.GyUtils;
import com.liyuan.utils.MailOperation;

@Controller
public class RegisterController {
	@Autowired
	RegisterService regService;
	@Autowired
	LoginMapper loginMapper;
	
	static String yzm;
	static String to;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject register(@RequestBody String params){
		JSONObject jsonParam=JSONObject.fromObject(params);
		return regService.register(jsonParam);
	}
	
	@RequestMapping(value="/forget",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject resetPassword(@RequestBody String params){
		JSONObject param=JSONObject.fromObject(params);
		JSONObject result=new JSONObject();
		MailOperation operation = new MailOperation();
        String user = "zly75509@163.com";
        String password = "sbsb75509";
        String host = "smtp.163.com";
        String from = "zly75509@163.com";
        to = param.getString("yx");// 收件人
        LoginEntity log=loginMapper.selectUser1(to);
        if(log==null){
        	result.put("success", false);
			result.put("message", "用户名不存在");
			return GyUtils.returnResult(true, "成功", result);
        }
        String subject = "修改密码验证";
        //邮箱内容
        StringBuffer sb = new StringBuffer();
        yzm =GyUtils.getUUid();
        sb.append("<!DOCTYPE>"+"<div bgcolor='#f1fcfa'   style='border:1px solid #d9f4ee; font-size:14px; line-height:22px; color:#005aa0;padding-left:1px;padding-top:5px;   padding-bottom:5px;'><span style='font-weight:bold;'>温馨提示：</span>"
                          + "<div style='width:950px;font-family:arial;'>欢迎，您的验证码为：<br/><h2 style='color:green'>"+yzm+"</h2><br/>本邮件由系统自动发出，请勿回复。<br/>感谢您的使用。<br/>钟黎阳的大学生兼职信息管理系统</div>"
                         +"</div>");
        try {
            boolean res = operation.sendMail(user, password, host, from, to,
                    subject, sb.toString());
            
            if(res==true){
            	 result.put("success", true);
                 result.put("message", "验证码发送成功");
                 return GyUtils.returnResult(true, "成功", result);  
            }else{
            	result.put("success", false);
                result.put("message", "验证码发送失败");
                return GyUtils.returnResult(true, "成功", result);  
            }
        } catch (Exception e) {
        	
        	result.put("success", false);
            result.put("message", "验证码发送失败");
            e.printStackTrace();
            return GyUtils.returnResult(true, "成功", result);  
        }

	}
	
	@RequestMapping(value="/yanzhen",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject yanzhenPassword(@RequestBody String params){
		JSONObject param=JSONObject.fromObject(params);
		JSONObject result=new JSONObject();
		String yzmreceive=param.getString("yzm");
		if(yzmreceive.equals(yzm)){
			 result.put("success", true);
             result.put("message", "验证码正确");
             return GyUtils.returnResult(true, "成功", result);  
		}else{
			 result.put("success", false);
             result.put("message", "验证码不正确");
             return GyUtils.returnResult(true, "成功", result); 
		}
	}
	
	@RequestMapping(value="/setpassword",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject setPassword(@RequestBody String params){
		JSONObject param=JSONObject.fromObject(params);
		JSONObject result=new JSONObject();
		String password=param.getString("password");
		int flag= loginMapper.setPassword(to, password);
		if(flag==1){
			 result.put("success", true);
             result.put("message", "重置密码成功");
             return GyUtils.returnResult(true, "成功", result);  
		}else{
			 result.put("success", false);
             result.put("message", "重置密码失败");
             return GyUtils.returnResult(true, "成功", result); 
		}
	}
}
