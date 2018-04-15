package com.liyuan.service.impl;

import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.logging.log4j.core.helpers.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liyuan.mapper.LoginMapper;
import com.liyuan.po.LoginEntity;
import com.liyuan.service.RegisterService;
import com.liyuan.utils.GyUtils;

@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	LoginMapper loginMapper;
	
	@Override
	public JSONObject register(JSONObject jsonparam) {
		String email=jsonparam.getString("email");
		String password=jsonparam.getString("password");
		LoginEntity login=loginMapper.selectUser(email);
		String uuid=GyUtils.getUUid();
		JSONObject result=new JSONObject();
		if(login!=null){
			result.put("success", false);
			result.put("message", "用户名已存在");
			return GyUtils.returnResult(true, "成功", result);
		}
		if(loginMapper.insertUser(email, password,uuid)!=0){
			result.put("success", true);
			result.put("message", "注册成功");
			return GyUtils.returnResult(true, "成功", result);
		}else{
			result.put("success", false);
			result.put("message", "注册失败");
			return GyUtils.returnResult(true, "成功", result);
		}
	}

}
