package com.liyuan.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liyuan.mapper.UserInfoMapper;
import com.liyuan.po.UserInfoEntity;
import com.liyuan.service.UserInfoService;
import com.liyuan.utils.GyUtils;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	UserInfoMapper userInfoMapper;

	@Override
	public JSONObject bcGrxx(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		String id=StringUtils.isBlank(params.optString("id"))?GyUtils.getUUid():params.optString("id");
		String sfzhm=params.getString("sfzhm");
		String sjhm=params.getString("sjhm");
		String tplj=new String();
		String txzp=new String();
		int type=params.getInt("type");
		String xm=params.getString("xm");
		String xxmc=params.getString("xxmc");
		String zymc=params.getString("zymc");
		
		int flag=0;
		
		if(StringUtils.isBlank(params.optString("id"))){
			flag=userInfoMapper.insertUserinfo(id, sfzhm, sjhm, tplj, txzp, type, xm, xxmc, zymc);
		}else{
			flag=userInfoMapper.updateUserinfo(id, sfzhm, sjhm, tplj, txzp, type, xm, xxmc, zymc);
		}
		
		JSONObject result=new JSONObject();
		if(flag==1){
			result.put("message", "成功");
			result.put("success", true);
			return GyUtils.returnResult(true, "成功", result);
		}else{
			result.put("message", "失败");
			result.put("success", false);
			return GyUtils.returnResult(true, "成功", result);
		}
	}

	@Override
	public JSONObject bjGrxx(String param, HttpServletRequest request) {
		HttpSession session=request.getSession(true);
		
		String bh=(String)session.getAttribute("id");
		UserInfoEntity user=userInfoMapper.selectUserinfo(bh);
		JSONObject data=new JSONObject();
		data.put("id", user.getId());
		data.put("sjhm",user.getSjhm());
		data.put("sfzhm", user.getSfzhm());
		data.put("tplj", user.getTplj());
		data.put("txzp", user.getTxzp());
		return null;
	}

}
