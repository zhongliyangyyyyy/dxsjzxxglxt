package com.liyuan.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.liyuan.mapper.AdminMapper;
import com.liyuan.po.JubaoEntity;
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
			data.put("zh", dsh.getZh());
			jsonArray.add(data);
		}
		result.put("data", jsonArray);
		result.put("success", true);
		result.put("message", "获取待审核列表成功");
		
 		return GyUtils.returnResult(true, "成功", result);
	}

	@Override
	public JSONObject shtgService(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		String id=params.getString("id");
		Date shsj=new Date();
		int zt=2;
		int flag=adminMapper.updataTgsh(id, shsj,zt);
		
		JSONObject result=new JSONObject();
		if(flag==1){
			result.put("success", true);
			result.put("message", "通过审核成功");
			return GyUtils.returnResult(true, "成功", result);
		}else{
			result.put("success", false);
			result.put("message", "通过审核失败");
			return GyUtils.returnResult(true, "成功", result);
		}
		
	}

	@Override
	public JSONObject shbtgService(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		String id=params.getString("id");
		Date shsj=new Date();
		int zt=3;
		int flag=adminMapper.updataTgsh(id, shsj,zt);
		
		JSONObject result=new JSONObject();
		if(flag==1){
			result.put("success", true);
			result.put("message", "不通过审核成功");
			return GyUtils.returnResult(true, "成功", result);
		}else{
			result.put("success", false);
			result.put("message", "不通过审核失败");
			return GyUtils.returnResult(true, "成功", result);
		}
	}

	@Override
	public JSONObject yshlbService(String param, HttpServletRequest request) {
		List<ShenheEntity> dshlist=adminMapper.selectYsh();
		
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
			data.put("zh", dsh.getZh());
			jsonArray.add(data);
		}
		result.put("data", jsonArray);
		result.put("success", true);
		result.put("message", "获取已审核列表成功");
		
 		return GyUtils.returnResult(true, "成功", result);
	}

	@Override
	public JSONObject scshxxService(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		
		String id=params.getString("id");
		
		int flag=adminMapper.deleteShxx(id);
		
		JSONObject result=new JSONObject();
		if(flag==1){
			result.put("success", true);
			result.put("message", "删除审核信息成功");
			return GyUtils.returnResult(true, "成功", result);
		}else{
			result.put("success", false);
			result.put("message", "删除审核信息失败");
			return GyUtils.returnResult(true, "成功", result);
		}
	}

	@Override
	public JSONObject dcljbService(String param, HttpServletRequest request) {
		List<JubaoEntity> dclList=adminMapper.selectDcl();
		
		JSONArray jsonArray=new JSONArray();
		for(JubaoEntity dcl:dclList){
			JSONObject data=new JSONObject();
			data.put("id", dcl.getId());
			data.put("jblx", dcl.getJblx());
			data.put("jbrid", dcl.getJbrid());
			data.put("bjbrid", dcl.getBjbrid());
			data.put("jbrxm", dcl.getJbrxm());
			data.put("bjbrxm", dcl.getBjbrxm());
			data.put("jbsj", GyUtils.dateTostring(dcl.getJbsj()));
			data.put("clsj", GyUtils.dateTostring(dcl.getClsj()));
			data.put("cljg", dcl.getCljg());
			data.put("jbnr", dcl.getJbnr());
			
			jsonArray.add(data);
		}
		JSONObject result=new JSONObject();
		result.put("data", jsonArray);
		result.put("success", true);
		result.put("message", "获取待处理举报列表成功");
		
		return GyUtils.returnResult(true, "成功", result);
	}

	@Override
	public JSONObject ycljbService(String param, HttpServletRequest request) {
		List<JubaoEntity> dclList=adminMapper.selectYcl();
		
		JSONArray jsonArray=new JSONArray();
		for(JubaoEntity dcl:dclList){
			JSONObject data=new JSONObject();
			data.put("id", dcl.getId());
			data.put("jblx", dcl.getJblx());
			data.put("jbrid", dcl.getJbrid());
			data.put("bjbrid", dcl.getBjbrid());
			data.put("jbrxm", dcl.getJbrxm());
			data.put("bjbrxm", dcl.getBjbrxm());
			data.put("jbsj", GyUtils.dateTostring(dcl.getJbsj()));
			data.put("clsj", GyUtils.dateTostring(dcl.getClsj()));
			data.put("cljg", dcl.getCljg());
			data.put("jbnr", dcl.getJbnr());
			
			jsonArray.add(data);
		}
		JSONObject result=new JSONObject();
		result.put("data", jsonArray);
		result.put("success", true);
		result.put("message", "获取已处理举报列表成功");
		
		return GyUtils.returnResult(true, "成功", result);
	}

	@Override
	public JSONObject lhService(String param, HttpServletRequest request) {
		JSONObject params=new JSONObject();
		String id=params.getString("id");
		String bjbrid=params.getString("bjbrid");
		String uuid=GyUtils.getUUid();
		Date lhsj=new Date();
		
		return null;
	}

	@Override
	public JSONObject byslService(String param, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
