package com.liyuan.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liyuan.mapper.JianliMapper;
import com.liyuan.po.JianliEntity;
import com.liyuan.service.JianliService;
import com.liyuan.utils.GyUtils;

@Service
public class JianliServiceImlp implements JianliService{
	
	@Autowired JianliMapper jianliMapper;

	/**
	 * 编辑、保存简历
	 */
	@Override
	public JSONObject personJianli(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		
		String c_syzid=(String)session.getAttribute("id");
		
		JianliEntity jianliEntity=jianliMapper.selectPersonJianli(c_syzid);
		
		JSONObject data=new JSONObject();
		JSONObject result=new JSONObject();
		data.put("id",jianliEntity.getC_id());
		data.put("c_name", jianliEntity.getC_name());
		data.put("n_xb", jianliEntity.getN_xb());
		data.put("c_sjhm", jianliEntity.getC_sjhm());
		data.put("c_yx", jianliEntity.getC_yx());
		data.put("c_qwgzdz", jianliEntity.getC_qwgzdz());
		data.put("n_gzxz", jianliEntity.getN_gzxz());
		data.put("c_qwzw", jianliEntity.getC_qwzw());
		data.put("n_qwyx", jianliEntity.getN_qwyx());
		data.put("c_gsmc", jianliEntity.getC_gsmc());
		data.put("c_zwmc", jianliEntity.getC_zwmc());
		data.put("c_xxmc", jianliEntity.getC_xxmc());
		data.put("n_gzjy", jianliEntity.getN_gzjy());
		data.put("n_xl", jianliEntity.getN_xl());
		data.put("c_zymc", jianliEntity.getC_zymc());
		data.put("dt_kssj", jianliEntity.getDt_kssj());
		data.put("dt_jssj", jianliEntity.getDt_jssj());
		data.put("c_zwms",jianliEntity.getC_zwms());
		data.put("c_jlmc", jianliEntity.getC_jlmc());
		data.put("c_zp", jianliEntity.getC_zp());
		data.put("c_syzid", jianliEntity.getC_syzid());
		data.put("n_xxxl", jianliEntity.getN_xxxl());
		
		result.put("result", data);
		result.put("success", true);
		result.put("message", "成功");
		
		return GyUtils.returnResult(true, "成功", result);
	}


	@Override
	public JSONObject bcJianli(String param, HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		
		JSONObject jsonObject=JSONObject.fromObject(param);
		
		String c_id=jsonObject.optString("id");
		String c_name=jsonObject.optString("name");
		int n_xb=jsonObject.optInt("xb");
		String c_sjhm=jsonObject.optString("sjhm");
		String c_yx=jsonObject.optString("yx");
		String c_qwgzdz=jsonObject.optString("qwgzdz");
		int n_gzxz=jsonObject.optInt("gzxz");
		String c_qwzw=jsonObject.optString("qwzw");
		int n_qwyx=jsonObject.optInt("qwyx");
		String c_gsmc=jsonObject.optString("gsmc");
		String c_zwmc=jsonObject.optString("zwmc");
		String c_xxmc=jsonObject.optString("xxmc");
		int n_gzjy=jsonObject.optInt("gzjy");
		int n_xl=jsonObject.optInt("xl");
		String c_zymc=jsonObject.optString("zymc");
		Date dt_kssj=GyUtils.stringTodate(jsonObject.getString("kssj"));
		Date dt_jssj=GyUtils.stringTodate(jsonObject.getString("jssj"));
		String c_zwms=jsonObject.optString("zwms");
		String c_jlmc=jsonObject.optString("jlmc");
		String c_zp=jsonObject.optString("zp");
		String c_syzid=jsonObject.optString("syzid");
		int n_xxxl=jsonObject.optInt("xxxl");
		
		int flag=0;
		
		if(StringUtils.isBlank(c_id)){
			c_id=GyUtils.getUUid();
			c_syzid=(String)session.getAttribute("id");
			flag=jianliMapper.insertJianli(c_id, c_name, n_xb, c_sjhm, c_yx,
					c_qwgzdz, n_gzxz, c_qwzw, n_qwyx, c_gsmc, c_zwmc, c_xxmc,
					n_gzjy, n_xl, c_zymc, dt_kssj, dt_jssj, c_zwms, c_jlmc, c_zp, c_syzid, n_xxxl);
		}else{
			flag=jianliMapper.updateJianli(c_id, c_name, n_xb, c_sjhm, c_yx, 
					c_qwgzdz, n_gzxz, c_qwzw, n_qwyx, c_gsmc, c_zwmc, c_xxmc,
					n_gzjy, n_xl, c_zymc, dt_kssj, dt_jssj, c_zwms, c_jlmc, c_zp, n_xxxl);
		}
		
		JSONObject resultJsonObject=new JSONObject();
		
		if(flag==1){
			resultJsonObject.put("success", true);
			resultJsonObject.put("message", "成功！");
		}else {
			resultJsonObject.put("success", false);
			resultJsonObject.put("message", "失败！");
		}
		
		return GyUtils.returnResult(true, "成功", resultJsonObject);
	}

}
