package com.liyuan.service.impl;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liyuan.mapper.TestMapper;
import com.liyuan.po.TestEntity;
import com.liyuan.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired TestMapper mapper;

	@Override
	public JSONObject person(String account,String password) {
		List<TestEntity> list=mapper.select();
		JSONArray jsonArray=new JSONArray();
		for(TestEntity t:list){
			JSONObject data=new JSONObject();
			data.put("name", t.getName());
			jsonArray.add(data); 
		}
		JSONObject result=new JSONObject();
		result.put("result", jsonArray);
		return result;
		
	}

}
