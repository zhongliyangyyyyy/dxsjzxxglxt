package com.liyuan.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liyuan.constant.JobConstant;
import com.liyuan.mapper.JobMapper;
import com.liyuan.po.JobInfoEntity;
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
	public JSONObject creatJob(JSONObject param, HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		
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
		
		int n_yxzt=JobConstant.YX;
		
		int flag=jobmapper.insertJobinfi(n_code, c_zwmc, n_gzxz, n_yx, n_gzjy, n_xlyq, c_zwms, c_gzdz, c_jsjlyx, dt_fbsj, n_zt, c_id, c_fbzid,n_yxzt);
		
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
	/**
	 * 查看job详细信息
	 */
	@Override
	public JSONObject ckJob(JSONObject param,  HttpServletRequest request) {
		//根据职位id获取职位信息
		String c_id=param.getString("id");
		JobInfoEntity job=jobmapper.selectJob(c_id);
		
		JSONObject result=new JSONObject();
		if(job!=null){
			JSONObject data=new JSONObject();
			
			data.put("c_id", job.getC_id());
			
			data.put("n_code",job.getN_code());
			
			data.put("c_zwmc", job.getC_zwmc());
			
			data.put("n_gzxz", job.getN_gzxz());
			
			data.put("n_yx", job.getN_yx());
			
			data.put("n_gzjy", job.getN_gzjy());
			
			data.put("n_xlyq", job.getN_xlyq());
			
			data.put("c_zwms", job.getC_zwms());
			
			data.put("c_gzdz", job.getC_gzdz());
			
			data.put("c_jsjlyx", job.getC_jsjlyx());
			
			data.put("n_llcs", job.getN_llcs());
			
			data.put("n_zt", job.getN_zt());
			
			data.put("dt_fbsj", GyUtils.dateTostring(job.getDt_fbsj()));
			
			data.put("c_fbzid", job.getC_fbzid());
			
			result.put("data", data);
			result.put("success", true);
			result.put("message", "成功");
			return GyUtils.returnResult(true, "成功", result);
		}else {
			result.put("success", false);
			result.put("message", "失败");
			return GyUtils.returnResult(true, "成功", result);
		}
	}

	/**
	 * 热门职位列表
	 */
	@Override
	public JSONObject hotJob(HttpServletRequest request) {
		List<JobInfoEntity> jobList=jobmapper.selectHotJob();
		JSONArray jsonArray=new JSONArray();
		JSONObject result=new JSONObject();
		for(JobInfoEntity job:jobList){
			
			JSONObject data=new JSONObject();
			
			data.put("c_id", job.getC_id());
			
			data.put("n_code",job.getN_code());
			
			data.put("c_zwmc", job.getC_zwmc());
			
			data.put("n_gzxz", job.getN_gzxz());
			
			data.put("n_yx", job.getN_yx());
			
			data.put("n_gzjy", job.getN_gzjy());
			
			data.put("n_xlyq", job.getN_xlyq());
			
			data.put("c_zwms", job.getC_zwms());
			
			data.put("c_gzdz", job.getC_gzdz());
			
			data.put("c_jsjlyx", job.getC_jsjlyx());
			
			data.put("n_llcs", job.getN_llcs());
			
			data.put("n_zt", job.getN_zt());
			
			data.put("dt_fbsj", GyUtils.dateTostring(job.getDt_fbsj()));
			
			data.put("c_fbzid", job.getC_fbzid());
			
			jsonArray.add(data);
		}
		result.put("result", jsonArray);
		result.put("success", true);
		result.put("message", "获取最热职位列表成功");
		return GyUtils.returnResult(true, "成功", result);
	}

	/**
	 * 最新职位列表
	 */
	@Override
	public JSONObject newJob(HttpServletRequest request) {
		List<JobInfoEntity> jobList=jobmapper.selectNewJob();
		JSONArray jsonArray=new JSONArray();
		JSONObject result=new JSONObject();
		for(JobInfoEntity job:jobList){
			
			JSONObject data=new JSONObject();
			
			data.put("c_id", job.getC_id());
			
			data.put("n_code",job.getN_code());
			
			data.put("c_zwmc", job.getC_zwmc());
			
			data.put("n_gzxz", job.getN_gzxz());
			
			data.put("n_yx", job.getN_yx());
			
			data.put("n_gzjy", job.getN_gzjy());
			
			data.put("n_xlyq", job.getN_xlyq());
			
			data.put("c_zwms", job.getC_zwms());
			
			data.put("c_gzdz", job.getC_gzdz());
			
			data.put("c_jsjlyx", job.getC_jsjlyx());
			
			data.put("n_llcs", job.getN_llcs());
			
			data.put("n_zt", job.getN_zt());
			
			data.put("dt_fbsj", GyUtils.dateTostring(job.getDt_fbsj()));
			
			data.put("c_fbzid", job.getC_fbzid());
			
			jsonArray.add(data);
		}
		result.put("result", jsonArray);
		result.put("success", true);
		result.put("message", "获取最新职位列表成功");
		return GyUtils.returnResult(true, "成功", result);
	}

	/**
	 * 搜索职位，和职位列表
	 */
	@Override
	public JSONObject searchJob(JSONObject param, HttpServletRequest request) {
		
		JSONObject bt=param.getJSONObject("bt");
		//搜索内容
		String c_nr=bt.getString("nr");
		//月薪开始
		int n_yxstart=bt.getInt("yxstart");
		//月薪结束
		int n_yxend=bt.getInt("yxend");
		//工作经验
		int n_gzjy=bt.getInt("gzjy");
		//最低学历
		int n_xlyq=bt.getInt("zdxl");
		//工作性质
		int n_gzxz=bt.getInt("gzxz");
		//发布时间
		int fbsj=bt.getInt("fbsj");
		//页面大小
		int pagesize=param.getInt("pagesize");
		//页面
		int page=param.getInt("page");
		
		Date now=new Date();
		
		Calendar cal = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。    
		
		cal.setTime(now);
		
		cal.add(Calendar.DAY_OF_YEAR,-fbsj);
		
		Date dt_fbsj=cal.getTime();
		
		Integer offset=(page-1)*pagesize;
		List<JobInfoEntity> joblist=jobmapper.
				selectSearchJob(c_nr, n_yxstart, n_yxend, n_gzjy, n_xlyq, n_gzxz, dt_fbsj, pagesize, offset);
		
		Integer totalPageNumber=(int)Math.ceil((double)jobmapper.
				selectSearchJobNumber(c_nr, n_yxstart, n_yxend, n_gzjy, n_xlyq, n_gzxz, dt_fbsj)/pagesize);
		
		JSONArray jsonArray=new JSONArray();
		JSONObject result=new JSONObject();
		
		for(JobInfoEntity job:joblist){
			
			JSONObject data=new JSONObject();
			
			data.put("c_id", job.getC_id());
			
			data.put("n_code",job.getN_code());
			
			data.put("c_zwmc", job.getC_zwmc());
			
			data.put("n_gzxz", job.getN_gzxz());
			
			data.put("n_yx", job.getN_yx());
			
			data.put("n_gzjy", job.getN_gzjy());
			
			data.put("n_xlyq", job.getN_xlyq());
			
			data.put("c_zwms", job.getC_zwms());
			
			data.put("c_gzdz", job.getC_gzdz());
			
			data.put("c_jsjlyx", job.getC_jsjlyx());
			
			data.put("n_llcs", job.getN_llcs());
			
			data.put("n_zt", job.getN_zt());
			
			data.put("dt_fbsj", GyUtils.dateTostring(job.getDt_fbsj()));
			
			data.put("c_fbzid", job.getC_fbzid());
			
			jsonArray.add(data);
		}
		
		result.put("totalPageNumber", totalPageNumber);
		result.put("result", jsonArray);
		result.put("success", true);
		result.put("message", "搜索职位列表成功");
		return GyUtils.returnResult(true, "成功", result);
	}

	/**
	 * 有效职位
	 */
	@Override
	public JSONObject yxJob(HttpServletRequest request) {
		HttpSession session=request.getSession(true);
		String c_fbzid=(String) session.getAttribute("id");
		
		List<JobInfoEntity> jobList=jobmapper.selectyxJob(c_fbzid);
		
		
		JSONArray jsonArray=new JSONArray();
		JSONObject result=new JSONObject();
		for(JobInfoEntity job:jobList){

			JSONObject data=new JSONObject();
			
			data.put("c_id", job.getC_id());
			
			data.put("n_code",job.getN_code());
			
			data.put("c_zwmc", job.getC_zwmc());
			
			data.put("n_gzxz", job.getN_gzxz());
			
			data.put("n_yx", job.getN_yx());
			
			data.put("n_gzjy", job.getN_gzjy());
			
			data.put("n_xlyq", job.getN_xlyq());
			
			data.put("c_zwms", job.getC_zwms());
			
			data.put("c_gzdz", job.getC_gzdz());
			
			data.put("c_jsjlyx", job.getC_jsjlyx());
			
			data.put("n_llcs", job.getN_llcs());
			
			data.put("n_zt", job.getN_zt());
			
			data.put("dt_fbsj", GyUtils.dateTostring(job.getDt_fbsj()));
			
			data.put("c_fbzid", job.getC_fbzid());
			
			jsonArray.add(data);
		}
		result.put("result", jsonArray);
		result.put("success", true);
		result.put("message", "有效职位");
		return GyUtils.returnResult(true, "成功", result);
	}

	/**
	 * 无效职位
	 */
	@Override
	public JSONObject wxJob(HttpServletRequest request) {
		HttpSession session=request.getSession(true);
		String c_fbzid=(String) session.getAttribute("id");
		
		List<JobInfoEntity> jobList=jobmapper.selectwxJob(c_fbzid);
		
		
		JSONArray jsonArray=new JSONArray();
		JSONObject result=new JSONObject();
		for(JobInfoEntity job:jobList){

			JSONObject data=new JSONObject();
			
			data.put("c_id", job.getC_id());
			
			data.put("n_code",job.getN_code());
			
			data.put("c_zwmc", job.getC_zwmc());
			
			data.put("n_gzxz", job.getN_gzxz());
			
			data.put("n_yx", job.getN_yx());
			
			data.put("n_gzjy", job.getN_gzjy());
			
			data.put("n_xlyq", job.getN_xlyq());
			
			data.put("c_zwms", job.getC_zwms());
			
			data.put("c_gzdz", job.getC_gzdz());
			
			data.put("c_jsjlyx", job.getC_jsjlyx());
			
			data.put("n_llcs", job.getN_llcs());
			
			data.put("n_zt", job.getN_zt());
			
			data.put("dt_fbsj", GyUtils.dateTostring(job.getDt_fbsj()));
			
			data.put("c_fbzid", job.getC_fbzid());
			
			jsonArray.add(data);
		}
		result.put("result", jsonArray);
		result.put("success", true);
		result.put("message", "有效职位");
		return GyUtils.returnResult(true, "成功", result);
	}

	/**
	 * 下线职位
	 */
	@Override
	public JSONObject xxJob(String param, HttpServletRequest request) {
		JSONObject jsonparam=JSONObject.fromObject(param);
		
		String c_id=jsonparam.getString("id");
		
		int flag=jobmapper.updateXxJob(c_id);
		
		JSONObject result=new JSONObject();
		if (flag==1) {
			result.put("success", true);
			result.put("message", "下线成功！");
			return GyUtils.returnResult(true, "成功", result);
		} else {
			result.put("success", false);
			result.put("message", "下线失败！");
			return GyUtils.returnResult(true, "成功", result);
		}
	}
	
	
	/**
	 * 上线职位
	 */
	@Override
	public JSONObject sxJob(String param, HttpServletRequest request) {
		JSONObject jsonparam=JSONObject.fromObject(param);
		
		String c_id=jsonparam.getString("id");
		
		int flag=jobmapper.updateSxJob(c_id);
		
		JSONObject result=new JSONObject();
		if (flag==1) {
			result.put("success", true);
			result.put("message", "上线成功！");
			return GyUtils.returnResult(true, "成功", result);
		} else {
			result.put("success", false);
			result.put("message", "上线失败！");
			return GyUtils.returnResult(true, "成功", result);
		}
	}
	
	/**
	 * 删除职位
	 */
	@Override
	public JSONObject scJob(String param, HttpServletRequest request) {
		JSONObject jsonparam=JSONObject.fromObject(param);
		
		String c_id=jsonparam.getString("id");
		
		int flag=jobmapper.deleteJob(c_id);
		
		JSONObject result=new JSONObject();
		if (flag==1) {
			result.put("success", true);
			result.put("message", "删除成功！");
			return GyUtils.returnResult(true, "成功", result);
		} else {
			result.put("success", false);
			result.put("message", "删除失败！");
			return GyUtils.returnResult(true, "成功", result);
		}
	}

	/**
	 * 我收藏职位列表
	 */
	@Override
	public JSONObject wscJob(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		HttpSession session=request.getSession(true);
		
		String c_userid=(String)session.getAttribute("id");
		
		List<JobInfoEntity> jobInfoEntities=jobmapper.selectWscJob(c_userid);
		

		JSONArray jsonArray=new JSONArray();
		JSONObject result=new JSONObject();
		for(JobInfoEntity job:jobInfoEntities){

			JSONObject data=new JSONObject();
			
			data.put("c_id", job.getC_id());
			
			data.put("n_code",job.getN_code());
			
			data.put("c_zwmc", job.getC_zwmc());
			
			data.put("n_gzxz", job.getN_gzxz());
			
			data.put("n_yx", job.getN_yx());
			
			data.put("n_gzjy", job.getN_gzjy());
			
			data.put("n_xlyq", job.getN_xlyq());
			
			data.put("c_zwms", job.getC_zwms());
			
			data.put("c_gzdz", job.getC_gzdz());
			
			data.put("c_jsjlyx", job.getC_jsjlyx());
			
			data.put("n_llcs", job.getN_llcs());
			
			data.put("n_zt", job.getN_zt());
			
			data.put("dt_fbsj", GyUtils.dateTostring(job.getDt_fbsj()));
			
			data.put("c_fbzid", job.getC_fbzid());
			
			jsonArray.add(data);
		}
		result.put("result", jsonArray);
		result.put("message", "获取我收藏职位列表成功");
		result.put("success", true);
		return GyUtils.returnResult(true, "成功", result);
	}

	/**
	 * 收藏职位按钮
	 */
	@Override
	public JSONObject wyscJob(String param, HttpServletRequest request) {
		
		JSONObject params=JSONObject.fromObject(param);
		HttpSession session=request.getSession(true);
		
		String c_userid=(String)session.getAttribute("id");
		
		String c_jobid=params.getString("id");
		
		String c_id=GyUtils.getUUid();
		
		int flag=jobmapper.insertWscJob(c_id, c_userid, c_jobid);
		
		JSONObject result=new JSONObject();
		if (flag==1) {
			result.put("success", true);
			result.put("message", "收藏职位成功！");
			return GyUtils.returnResult(true, "成功", result);
		} else {
			result.put("success", false);
			result.put("message", "收藏职位失败！");
			return GyUtils.returnResult(true, "成功", result);
		}
	}

	/**
	 * 取消收藏按钮
	 */
	@Override
	public JSONObject qxscJob(String param, HttpServletRequest request) {
		
		JSONObject params=JSONObject.fromObject(param);
		HttpSession session=request.getSession(true);
		
		String c_userid=(String)session.getAttribute("id");
		
		String c_jobid=params.getString("id");
		
		int flag=jobmapper.deleteWscJob(c_userid, c_jobid);
		
		JSONObject result=new JSONObject();
		if (flag==1) {
			result.put("success", true);
			result.put("message", "删除收藏职位成功！");
			return GyUtils.returnResult(true, "成功", result);
		} else {
			result.put("success", false);
			result.put("message", "删除收藏职位失败！");
			return GyUtils.returnResult(true, "成功", result);
		}
	}
}
