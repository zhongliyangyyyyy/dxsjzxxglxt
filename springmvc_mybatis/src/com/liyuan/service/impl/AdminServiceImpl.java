package com.liyuan.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.liyuan.mapper.AdminMapper;
import com.liyuan.po.ShenheEntity;
import com.liyuan.service.AdminService;
import com.liyuan.utils.GyUtils;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminMapper adminMapper;

	@Override
	public JSONObject dshlbService(String param, HttpServletRequest request) {
		List<ShenheEntity> dshlist=adminMapper.selectDsh();
		
		JSONArray jsonArray=new JSONArray();
		JSONObject result=new JSONObject();
		for(ShenheEntity dsh:dshlist){
			JSONObject data=new JSONObject();
			data.put("id", dsh.getId());
			data.put("shlx", dsh.getShlx());
			data.put("fqsj",GyUtils.dateTostring(dsh.getFqsj()));
			data.put("shsj",GyUtils.dateTostring(dsh.getShsj()));
			data.put("zt", dsh.getZt());
			data.put("jlid", dsh.getJlid());
			data.put("shrxm", dsh.getShrxm());
			jsonArray.add(data);
		}
		result.put("data", jsonArray);
		result.put("success", true);
		result.put("message", "获取待审核列表成功");
		
 		return GyUtils.returnResult(true, "成功", result);
	}

}
