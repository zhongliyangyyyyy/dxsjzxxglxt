package com.liyuan.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liyuan.mapper.LoginMapper;
import com.liyuan.po.LoginEntity;
import com.liyuan.service.LoginService;
import com.liyuan.utils.GyUtils;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginMapper loginMapper;
	
	@Override
	public JSONObject logIN(String email, String password, HttpServletRequest request) {
		final HttpSession session = request.getSession(true);

		LoginEntity log=loginMapper.selectUser1(email);
		JSONObject result=new JSONObject();
		if(log==null){
			result.put("success", false);
			result.put("message", "用户名不存在");
			return GyUtils.returnResult(true, "成功", result);
		}
		if(StringUtils.equals(email, log.getEmail())&&StringUtils.equals(password, log.getPassword())){
			result.put("success", true);
			result.put("message", "登入成功");
			result.put("email", log.getEmail());
			result.put("type", log.getType());
			result.put("id", log.getId());
			
			if(loginMapper.selectUserInfo(log.getId())!=0){
				LoginEntity log1=loginMapper.selectUser(email);
				if(log.getType()==3){
					result.put("url", "main.html");
				}else{
					result.put("url", "index.html");
				}
				result.put("user", log1.getName());
			}else{
				if(log.getType()==3){
					result.put("url", "main.html");
				}else{
					result.put("url", "gerenxinxi.html");
				}
				result.put("user","");
			}
			session.setAttribute("email", log.getEmail());
			session.setAttribute("logined", true);
			session.setAttribute("type", log.getType());
			session.setAttribute("id", log.getId());
			return GyUtils.returnResult(true, "成功", result);
		}else{
			result.put("success", false);
			result.put("message", "密码错误");
			return GyUtils.returnResult(true, "成功", result);
		}
	}
}
