package com.liyuan.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liyuan.constant.ReceiveJianliConstant;
import com.liyuan.mapper.JianliMapper;
import com.liyuan.mapper.JobMapper;
import com.liyuan.po.JianliEntity;
import com.liyuan.po.JobInfoEntity;
import com.liyuan.po.JobTypeEntity;
import com.liyuan.po.LoginEntity;
import com.liyuan.po.ReceJianliEntity;
import com.liyuan.po.WscjobEntity;
import com.liyuan.service.JianliService;
import com.liyuan.utils.GyUtils;
import com.liyuan.utils.MailOperation;

@Service
public class JianliServiceImlp implements JianliService{
	
	@Autowired 
	JianliMapper jianliMapper;
	
	@Autowired 
	JobMapper jobMapper;

	/**
	 * 编辑
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
		data.put("c_xb", jianliEntity.getN_xb()==1?"男":"女");
		data.put("n_xb", jianliEntity.getN_xb());
		data.put("c_sjhm", jianliEntity.getC_sjhm());
		data.put("c_yx", jianliEntity.getC_yx());
		data.put("c_qwgzdz", jianliEntity.getC_qwgzdz());
		data.put("c_gzxz",jianliEntity.getN_gzxz()==1?"兼职":"全职" );
		data.put("n_gzxz",jianliEntity.getN_gzxz());
		data.put("c_qwzw", jianliEntity.getC_qwzw());
		data.put("n_qwyx", jianliEntity.getN_qwyx());
		data.put("c_gsmc", jianliEntity.getC_gsmc());
		data.put("c_zwmc", jianliEntity.getC_zwmc());
		data.put("c_xxmc", jianliEntity.getC_xxmc());
		data.put("c_gzjy",jianliEntity.getN_gzjy()==1?"无工作经验":(jianliEntity.getN_gzjy()==2?"有工作经验":"无工作经验") );
		data.put("n_gzjy",jianliEntity.getN_gzjy());
		data.put("c_xl", jianliEntity.getN_xl()==1?"无要求":(jianliEntity.getN_xl()==2?"大专":
			(jianliEntity.getN_xl()==3?"本科":(jianliEntity.getN_xl()==4?"硕士":"博士"))));
		data.put("n_xl", jianliEntity.getN_xl());
		data.put("c_zymc", jianliEntity.getC_zymc());
		data.put("dt_kssj", GyUtils.dateTostring2(jianliEntity.getDt_kssj()));
		data.put("dt_jssj", GyUtils.dateTostring2(jianliEntity.getDt_jssj()));
		data.put("c_zwms",jianliEntity.getC_zwms());
		data.put("c_jlmc", jianliEntity.getC_jlmc());
	
			data.put("c_zp",jianliEntity.getC_zp());

		data.put("c_syzid", jianliEntity.getC_syzid());
		
		result.put("result", data);
		result.put("success", true);
		result.put("message", "成功");
		
		return GyUtils.returnResult(true, "成功", result);
	}


	/**
	 *保存简历
	 */
	@Override
	public JSONObject bcJianli(String param, HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		String yhid=(String)session.getAttribute("id");
		JianliEntity jianliEntity=jianliMapper.selectPersonJianli(yhid);
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
		Date dt_kssj=GyUtils.stringTodate(jsonObject.optString("kssj"));
		Date dt_jssj=GyUtils.stringTodate(jsonObject.optString("jssj"));
		String c_zwms=jsonObject.optString("zwms");
		String c_jlmc=jsonObject.optString("jlmc");
		String c_zp=new String();
		try {
			c_zp = URLEncoder.encode(jsonObject.optString("zp"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		int flag=0;
		
		if(jianliEntity==null){
			c_id=GyUtils.getUUid();
			flag=jianliMapper.insertJianli(c_id, c_name, n_xb, c_sjhm, c_yx,
					c_qwgzdz, n_gzxz, c_qwzw, n_qwyx, c_gsmc, c_zwmc, c_xxmc,
					n_gzjy, n_xl, c_zymc, dt_kssj, dt_jssj, c_zwms, c_jlmc, c_zp, yhid);
		}else{
			flag=jianliMapper.updateJianli(yhid, c_name, n_xb, c_sjhm, c_yx, 
					c_qwgzdz, n_gzxz, c_qwzw, n_qwyx, c_gsmc, c_zwmc, c_xxmc,
					n_gzjy, n_xl, c_zymc, dt_kssj, dt_jssj, c_zwms, c_jlmc, c_zp);
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


	@Override
	public JSONObject dclJianli(String param,HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		JSONObject params=JSONObject.fromObject(param);
		
		int n_gzjy=0;
		int n_zdxl=0;
		int total=0;
		String c_fbzid=(String)session.getAttribute("id");
		List<ReceJianliEntity> receJianliEntities=jianliMapper.selectDclJianli(n_zdxl, n_gzjy, c_fbzid);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		for(ReceJianliEntity jianli:receJianliEntities){
			JSONObject data=new JSONObject();
			data.put("jlid", jianli.getC_jlid());
			data.put("id",jianli.getC_id());
			data.put("name", jianli.getC_name());
			data.put("jlmc", jianli.getC_jlmc());
			data.put("xb", jianli.getN_xb());
			data.put("xl", jianli.getN_xl());
			data.put("byxx", jianli.getC_byxx());
			data.put("zy", jianli.getC_zy());
			data.put("ypzw", jianli.getC_ypzw());
			data.put("tdsj", GyUtils.dateTostring(jianli.getDt_tdsj()));
			data.put("zp", jianli.getZp());
			data.put("qwgzdz", jianli.getQwgzdz());
			data.put("gzjy", jianli.getGzjy());
			data.put("jobid", jianli.getJobid());
			total++;
			jsonArray.add(data);
		}
		result.put("success", true);
		result.put("message", "待处理简历！");
		result.put("result", jsonArray);
		result.put("total", total);
		return GyUtils.returnResult(true, "成功", result);
	}


	@Override
	public JSONObject ddJianli(String param, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		JSONObject params=JSONObject.fromObject(param);
		int n_gzjy=0;
		int n_zdxl=0;
		int total=0;
		String c_fbzid=(String)session.getAttribute("id");
		List<ReceJianliEntity> receJianliEntities=jianliMapper.selectDdJianli(n_zdxl, n_gzjy, c_fbzid);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		for(ReceJianliEntity jianli:receJianliEntities){
			JSONObject data=new JSONObject();
			data.put("jlid", jianli.getC_jlid());
			data.put("id",jianli.getC_id());
			data.put("name", jianli.getC_name());
			data.put("jlmc", jianli.getC_jlmc());
			data.put("xb", jianli.getN_xb());
			data.put("xl", jianli.getN_xl());
			data.put("byxx", jianli.getC_byxx());
			data.put("zy", jianli.getC_zy());
			data.put("ypzw", jianli.getC_ypzw());
			data.put("tdsj", GyUtils.dateTostring(jianli.getDt_tdsj()));
			data.put("zp", jianli.getZp());
			data.put("qwgzdz", jianli.getQwgzdz());
			data.put("gzjy", jianli.getGzjy());
			data.put("jobid", jianli.getJobid());
			total++;
			jsonArray.add(data);
		}
		result.put("success", true);
		result.put("message", "待定简历！");
		result.put("result", jsonArray);
		result.put("total", total);
		return GyUtils.returnResult(true, "成功", result);
	}


	@Override
	public JSONObject ytzmsJianli(String param, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		JSONObject params=JSONObject.fromObject(param);
		int n_gzjy=0;
		int n_zdxl=0;
		int total=0;
		String c_fbzid=(String)session.getAttribute("id");
		List<ReceJianliEntity> receJianliEntities=jianliMapper.selectYtzmsJianli(n_zdxl, n_gzjy, c_fbzid);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		for(ReceJianliEntity jianli:receJianliEntities){
			JSONObject data=new JSONObject();
			data.put("jlid", jianli.getC_jlid());
			data.put("id",jianli.getC_id());
			data.put("name", jianli.getC_name());
			data.put("jlmc", jianli.getC_jlmc());
			data.put("xb", jianli.getN_xb());
			data.put("xl", jianli.getN_xl());
			data.put("byxx", jianli.getC_byxx());
			data.put("zy", jianli.getC_zy());
			data.put("ypzw", jianli.getC_ypzw());
			data.put("tdsj", GyUtils.dateTostring(jianli.getDt_tdsj()));
			data.put("zp", jianli.getZp());
			data.put("qwgzdz", jianli.getQwgzdz());
			data.put("gzjy", jianli.getGzjy());
			data.put("jobid", jianli.getJobid());
			total++;
			jsonArray.add(data);
		}
		result.put("success", true);
		result.put("message", "已通知面试简历！");
		result.put("result", jsonArray);
		result.put("total", total);
		return GyUtils.returnResult(true, "成功", result);
	}


	@Override
	public JSONObject bhsJianli(String param, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		JSONObject params=JSONObject.fromObject(param);
		int n_gzjy=0;
		int n_zdxl=0;
		int total=0;
		String c_fbzid=(String)session.getAttribute("id");
		List<ReceJianliEntity> receJianliEntities=jianliMapper.selectBhsJianli(n_zdxl, n_gzjy, c_fbzid);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		for(ReceJianliEntity jianli:receJianliEntities){
			JSONObject data=new JSONObject();
			data.put("jlid", jianli.getC_jlid());
			data.put("id",jianli.getC_id());
			data.put("name", jianli.getC_name());
			data.put("jlmc", jianli.getC_jlmc());
			data.put("xb", jianli.getN_xb());
			data.put("xl", jianli.getN_xl());
			data.put("byxx", jianli.getC_byxx());
			data.put("zy", jianli.getC_zy());
			data.put("ypzw", jianli.getC_ypzw());
			data.put("tdsj", GyUtils.dateTostring(jianli.getDt_tdsj()));
			data.put("zp", jianli.getZp());
			data.put("qwgzdz", jianli.getQwgzdz());
			data.put("gzjy", jianli.getGzjy());
			data.put("jobid", jianli.getJobid());
			total++;
			jsonArray.add(data);
		}
		result.put("success", true);
		result.put("message", "不合适简历！");
		result.put("result", jsonArray);
		result.put("total", total);
		return GyUtils.returnResult(true, "成功", result);
	}


	@Override
	public JSONObject tgmsJianli(String param, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		JSONObject params=JSONObject.fromObject(param);
		int n_gzjy=0;
		int n_zdxl=0;
		int total=0;
		String c_fbzid=(String)session.getAttribute("id");
		List<ReceJianliEntity> receJianliEntities=jianliMapper.selectTgmsJianli(n_zdxl, n_gzjy, c_fbzid);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		for(ReceJianliEntity jianli:receJianliEntities){
			JSONObject data=new JSONObject();
			data.put("jlid", jianli.getC_jlid());
			data.put("id",jianli.getC_id());
			data.put("name", jianli.getC_name());
			data.put("jlmc", jianli.getC_jlmc());
			data.put("xb", jianli.getN_xb());
			data.put("xl", jianli.getN_xl());
			data.put("byxx", jianli.getC_byxx());
			data.put("zy", jianli.getC_zy());
			data.put("ypzw", jianli.getC_ypzw());
			data.put("tdsj", GyUtils.dateTostring(jianli.getDt_tdsj()));
			data.put("zp", jianli.getZp());
			data.put("qwgzdz", jianli.getQwgzdz());
			data.put("gzjy", jianli.getGzjy());
			data.put("jobid", jianli.getJobid());
			total++;
			jsonArray.add(data);
		}
		result.put("success", true);
		result.put("total", total);
		result.put("message", "通过面试简历！");
		result.put("result", jsonArray);
		return GyUtils.returnResult(true, "成功", result);
	}


	@Override
	public JSONObject setBhs(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		String c_id=params.getString("id");
		int flag=jianliMapper.updateReceJianli(c_id, ReceiveJianliConstant.BHSJL);
		JSONObject result=new JSONObject();
		if(flag==1){
			result.put("success", true);
			result.put("message", "设置为不合适成功");
			return GyUtils.returnResult(true, "成功", result);
		}else{
			result.put("success", false);
			result.put("message", "失败");
			return GyUtils.returnResult(true, "成功", result);
		}
	}


	@Override
	public JSONObject setDd(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		String c_id=params.getString("id");
		int flag=jianliMapper.updateReceJianli(c_id, ReceiveJianliConstant.DDJL);
		JSONObject result=new JSONObject();
		if(flag==1){
			result.put("success", true);
			result.put("message", "设置为待定成功");
			return GyUtils.returnResult(true, "成功", result);
		}else{
			result.put("success", false);
			result.put("message", "失败");
			return GyUtils.returnResult(true, "成功", result);
		}
	}


	@Override
	public JSONObject deletJl(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		String c_id=params.getString("id");
		int flag=jianliMapper.delectReceJianli(c_id);
		JSONObject result=new JSONObject();
		if(flag==1){
			result.put("success", true);
			result.put("message", "删除成功");
			return GyUtils.returnResult(true, "成功", result);
		}else{
			result.put("success", false);
			result.put("message", "失败");
			return GyUtils.returnResult(true, "成功", result);
		}
	}


	@Override
	public JSONObject setTzms(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		JSONObject result=new JSONObject();
		String c_id=params.getString("id");
		WscjobEntity wsc=jobMapper.selectyx(c_id);
		MailOperation operation = new MailOperation();
        String user = "zly75509@163.com";
        String password = "sbsb75509";
        String host = "smtp.163.com";
        String from = "zly75509@163.com";
        String to = wsc.getEmail();// 收件人
        String subject = "收到面试通知";
        //邮箱内容
        StringBuffer sb = new StringBuffer();
        sb.append("<!DOCTYPE>"+"<div bgcolor='#f1fcfa'   style='border:1px solid #d9f4ee; font-size:14px; line-height:22px; color:#005aa0;padding-left:1px;padding-top:5px;   padding-bottom:5px;'><span style='font-weight:bold;'>温馨提示：</span>"
                          + "<div style='width:950px;font-family:arial;'>您好：<br/><h2 style='color:green'>"+"您刚刚收到了一个面试通知，赶紧去查看吧！"+"</h2><br/>本邮件由系统自动发出，请勿回复。<br/>感谢您的使用。<br/>钟黎阳的大学生兼职信息管理系统</div>"
                         +"</div>");
        try {
            boolean res = operation.sendMail(user, password, host, from, to,
                    subject, sb.toString());
            
            if(res==false){
            	result.put("success", false);
                result.put("message", "发送通知邮件失败");
                return GyUtils.returnResult(true, "成功", result);  
            }
        } catch (Exception e) {
        	
        	result.put("success", false);
            result.put("message", "发送通知邮件失败");
            e.printStackTrace();
            return GyUtils.returnResult(true, "成功", result);  
        }

		int flag=jianliMapper.updateReceJianli(c_id, ReceiveJianliConstant.YTZMSJL);
		if(flag==1){
			result.put("success", true);
			result.put("message", "已成功发送邮件，通知成功！");
			return GyUtils.returnResult(true, "成功", result);
		}else{
			result.put("success", false);
			result.put("message", "失败");
			return GyUtils.returnResult(true, "成功", result);
		}
	}


	@Override
	public JSONObject setTgms(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		String c_id=params.getString("id");
		int flag=jianliMapper.updateReceJianli(c_id, ReceiveJianliConstant.TGMSJL);
		JSONObject result=new JSONObject();
		if(flag==1){
			result.put("success", true);
			result.put("message", "设置为通过面试成功");
			return GyUtils.returnResult(true, "成功", result);
		}else{
			result.put("success", false);
			result.put("message", "失败");
			return GyUtils.returnResult(true, "成功", result);
		}
	}

	/**
	 * 已投递简历列表
	 */
	@Override
	public JSONObject ytdJianli(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		HttpSession session=request.getSession(true);
		String c_userid=(String)session.getAttribute("id");
		int n_zt=params.getInt("n_zt");
		
		JianliEntity personJianli=jianliMapper.selectPersonJianli(c_userid);
		String c_jlid=personJianli.getC_id();
		
		List<ReceJianliEntity> jianliEntity=jianliMapper.selectYtdJianli(c_jlid,n_zt);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		for(ReceJianliEntity jianli:jianliEntity){
			JSONObject data=new JSONObject();
			data.put("id",jianli.getC_id());
			data.put("name", jianli.getC_name());
			data.put("jlmc", jianli.getC_jlmc());
			data.put("xb", jianli.getN_xb());
			data.put("xl", jianli.getN_xl());
			data.put("byxx", jianli.getC_byxx());
			data.put("zy", jianli.getC_zy());
			data.put("ypzw", jianli.getC_ypzw());
			data.put("jobid", jianli.getJobid());
			data.put("tdsj", GyUtils.dateTostring(jianli.getDt_tdsj()));
			data.put("gzdz", jianli.getGzdz())	;
			data.put("zt", jianli.getZt());
			jsonArray.add(data);
		}
		result.put("success", true);
		result.put("message", "我投递的简历！");
		result.put("result", jsonArray);
		return GyUtils.returnResult(true, "成功", result);
	}

	/**
	 * 投递简历
	 */
	@Override
	public JSONObject tdJianli(String param, HttpServletRequest request) {
		
		JSONObject params=JSONObject.fromObject(param);
		JSONObject result=new JSONObject();
		HttpSession session=request.getSession(true);
		String c_userid=(String)session.getAttribute("id");
		String c_uuid=GyUtils.getUUid();
		String c_jobid=params.getString("id");
		JianliEntity personJianli=jianliMapper.selectPersonJianli(c_userid);
		if(personJianli==null){
			result.put("success", false);
			result.put("message", "请先填写简历！");
			return GyUtils.returnResult(true, "成功", result);
		}
		String c_jlid=personJianli.getC_id();
		if(jobMapper.selectWtd(c_jlid, c_jobid)!=null){
			result.put("success", false);
			result.put("message", "已投递简历请勿重复投递！");
			return GyUtils.returnResult(true, "成功", result);
		}
		int n_zt=ReceiveJianliConstant.DCLJL;
		int flag=jianliMapper.insertReceJianli(c_uuid, c_jlid, c_jobid, n_zt, new Date());
		
		if(flag==1){
			result.put("success", true);
			result.put("message", "投递简历成功");
			return GyUtils.returnResult(true, "成功", result);
		}else{
			result.put("success", false);
			result.put("message", "投递简历失败");
			return GyUtils.returnResult(true, "成功", result);
		}
	}


	/**
	 * 查看简历
	 */
	@Override
	public JSONObject ckJianli(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		String c_jlid=params.getString("jlid");

		JianliEntity jianliEntity=jianliMapper.selectPersonJianliByid(c_jlid);
		
		JSONObject data=new JSONObject();
		JSONObject result=new JSONObject();
		data.put("id",jianliEntity.getC_id());
		data.put("c_name", jianliEntity.getC_name());
		data.put("c_xb", jianliEntity.getN_xb()==1?"男":"女");
		data.put("n_xb", jianliEntity.getN_xb());
		data.put("c_sjhm", jianliEntity.getC_sjhm());
		data.put("c_yx", jianliEntity.getC_yx());
		data.put("c_qwgzdz", jianliEntity.getC_qwgzdz());
		data.put("c_gzxz",jianliEntity.getN_gzxz()==1?"兼职":"全职" );
		data.put("n_gzxz",jianliEntity.getN_gzxz());
		data.put("c_qwzw", jianliEntity.getC_qwzw());
		data.put("n_qwyx", jianliEntity.getN_qwyx());
		data.put("c_gsmc", jianliEntity.getC_gsmc());
		data.put("c_zwmc", jianliEntity.getC_zwmc());
		data.put("c_xxmc", jianliEntity.getC_xxmc());
		data.put("c_gzjy",jianliEntity.getN_gzjy()==1?"无工作经验":(jianliEntity.getN_gzjy()==2?"有工作经验":"无工作经验") );
		data.put("n_gzjy",jianliEntity.getN_gzjy());
		data.put("c_xl", jianliEntity.getN_xl()==1?"无要求":(jianliEntity.getN_xl()==2?"大专":
			(jianliEntity.getN_xl()==3?"本科":(jianliEntity.getN_xl()==4?"硕士":"博士"))));
		data.put("n_xl", jianliEntity.getN_xl());
		data.put("c_zymc", jianliEntity.getC_zymc());
		data.put("dt_kssj", GyUtils.dateTostring2(jianliEntity.getDt_kssj()));
		data.put("dt_jssj", GyUtils.dateTostring2(jianliEntity.getDt_jssj()));
		data.put("c_zwms",jianliEntity.getC_zwms());
		data.put("c_jlmc", jianliEntity.getC_jlmc());
	
			data.put("c_zp",jianliEntity.getC_zp());

		data.put("c_syzid", jianliEntity.getC_syzid());
		result.put("result", data);
		result.put("success", true);
		result.put("message", "成功");
		
		return GyUtils.returnResult(true, "成功", result);
	}


	@Override
	public JSONObject tdjltj(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		String time=params.optString("time");
		List<JobTypeEntity> jobs=new ArrayList<>();
		if(StringUtils.isBlank(time)){
			 jobs=jianliMapper.selectTdjl();
		}else{
			String kssj=time.substring(0, 7);
			String jssj=time.substring(9,17);
			Date starttime=GyUtils.stringTodate(kssj+"-01 00:00");
			Date endtime=GyUtils.stringTodate(jssj+"-30 23:59");
			jobs=jianliMapper.selectTdjl2(starttime,endtime);
		}
		
		List<String> jobtype1=new ArrayList<String>();
		for(JobTypeEntity job:jobs){
			if(jobtype1.contains(job.getC_type1())){
				continue;
			}else{
				jobtype1.add(job.getC_type1());
			}
		}
		
		JSONArray jsonArray=new JSONArray();
		List<String> name=new ArrayList<>();
		for(String type1:jobtype1){
			int sum=0;
			JSONObject data=new JSONObject();
			for(JobTypeEntity job:jobs){
				if(job.getC_type1().equals(type1)){
					sum++;
				}
			}
			data.put("value", sum);
			data.put("name", type1);
			jsonArray.add(data);
			name.add(type1);
		}
		
		JSONObject result=new JSONObject();
		
		result.put("result", jsonArray);
		result.put("success", true);
		result.put("message", "获取投递简历统计成功!");
		result.put("name", name);
		return GyUtils.returnResult(true, "成功", result);
	}

}
