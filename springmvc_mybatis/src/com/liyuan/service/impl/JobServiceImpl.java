package com.liyuan.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.liyuan.constant.JobConstant;
import com.liyuan.mapper.JobMapper;
import com.liyuan.po.JobTypeEntity;
import com.liyuan.service.JobService;
import com.liyuan.utils.GyUtils;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	JobMapper jobmapper;
	
	
	/**
	 * 获取工作种类列表
	 */
	@Override
	public JSONObject getJobtype() {
		List<JobTypeEntity> jobtypelist=jobmapper.selectJobtype();
		List<String> jobtype1=new ArrayList<String>();
		List<String> jobtype3=new ArrayList<String>();
		for(JobTypeEntity job:jobtypelist){
			if(jobtype1.contains(job.getC_type1())){
				continue;
			}else{
				jobtype1.add(job.getC_type1());
			}
		}
		
		JSONArray resultjsonarray=new JSONArray();
		JSONObject result=new JSONObject();
		for(String type1:jobtype1){
			JSONObject data1=new JSONObject();
			JSONArray jsonarray=new JSONArray();
			List<String> jobtype2=new ArrayList<String>();
			for(JobTypeEntity job:jobtypelist){
				if(type1.equals(job.getC_type1())){
					if(!jobtype2.contains(job.getC_type2())){						
						jobtype2.add(job.getC_type2());
					}else{
						continue;
					}
				}
			}
			JSONArray jsonarray2=new JSONArray();
			for(String type2:jobtype2){
				for(JobTypeEntity job:jobtypelist){
					if(type2.equals(job.getC_type2())){
						JSONObject data2=new JSONObject();
						data2.put("name", job.getC_type3());
						data2.put("code", job.getN_code());
						jsonarray2.add(data2);
					}
				} 
				data1.put("name", type2);
				data1.put("type",jsonarray2);
				jsonarray.add(data1);
			}
			result.put("type",jsonarray);
			result.put("name", type1);
			resultjsonarray.add(result);
		}
		JSONObject result1=new JSONObject();
		result1.put("result",resultjsonarray);
		return GyUtils.returnResult(true, "成功", result1);
	}
	
	/**
	 *创建工作信息 
	 */
	@Override
	public JSONObject creatJob(JSONObject param,HttpSession session) {
		int n_code=param.getInt("zwlb");
		String c_zwmc=param.getString("zwmc");
		int n_gzxz=param.getInt("gzxz");
		int n_yx=param.getInt("yx");
		int n_gzjy=param.getInt("gzjy");
		int n_xlyq=param.getInt("xlyq");
		String c_zwms=param.getString("zwms");
		String c_gzdz=param.getString("gzdz");
		String c_jsjlyx=param.getString("jsjlyx");
		String c_id=GyUtils.getUUid();
		String c_fbzid=(String)session.getAttribute("id");
		int n_zt=JobConstant.SHZ;
		Date dt_fbsj=new Date();
		int flag=jobmapper.insertJobinfi(n_code, c_zwmc, n_gzxz, n_yx, n_gzjy, n_xlyq, c_zwms, c_gzdz, c_jsjlyx, dt_fbsj, n_zt, c_id, c_fbzid);
		
		JSONObject result=new JSONObject();
		
		if(flag==1){
			result.put("success", true);
			result.put("message", "发布成功，等待管理员审核！");
			return GyUtils.returnResult(true, "成功", result);
		}else{
			result.put("success", false);
			result.put("message", "发布失败，请重新尝试！");
			return GyUtils.returnResult(true, "成功", result);
		}
	}
	
}
