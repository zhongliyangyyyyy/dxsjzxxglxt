package com.liyuan.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liyuan.mapper.JianliMapper;
import com.liyuan.mapper.JobMapper;
import com.liyuan.mapper.UserInfoMapper;
import com.liyuan.po.CommentEntity;
import com.liyuan.po.JianliEntity;
import com.liyuan.po.JobInfoEntity;
import com.liyuan.po.UserInfoEntity;
import com.liyuan.service.UserInfoService;
import com.liyuan.utils.GyUtils;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	UserInfoMapper userInfoMapper;
	@Autowired
	JianliMapper jianliMapper;
	@Autowired
	JobMapper jobMapper;

	@Override
	public JSONObject bcGrxx(String param, HttpServletRequest request) {
		HttpSession session = request.getSession(true);

		String bh = (String) session.getAttribute("id");

		JSONObject params = JSONObject.fromObject(param);
		String id = StringUtils.isBlank(params.optString("id")) ? GyUtils
				.getUUid() : params.optString("id");
		String sfzhm = params.getString("sfzhm");
		String sjhm = params.getString("sjhm");
		String tplj = params.optString("tplj");
		String txzp = params.getString("txzp");
		int type = params.getInt("type");
		String xm = params.getString("xm");
		String xxmc = StringUtils.isBlank(params.optString("xxmc")) ? ""
				: params.optString("xxmc");
		String zymc = StringUtils.isBlank(params.optString("zymc")) ? ""
				: params.optString("zymc");

		int flag = 0;

		if (StringUtils.isBlank(params.optString("id"))) {
			flag = userInfoMapper.insertUserinfo(id, sfzhm, sjhm, tplj, txzp,
					type, xm, xxmc, zymc, bh);
			int flag1 = userInfoMapper.updateType(type, bh);
			int flag2 = userInfoMapper.updateZp(bh, txzp);
		} else {
			flag = userInfoMapper.updateUserinfo(id, sfzhm, sjhm, tplj, txzp,
					type, xm, xxmc, zymc);
			int flag1 = userInfoMapper.updateType(type, bh);
			int flag2 = userInfoMapper.updateZp(bh, txzp);
		}

		JSONObject result = new JSONObject();
		if (flag == 1) {
			result.put("message", "成功");
			result.put("success", true);
			return GyUtils.returnResult(true, "成功", result);
		} else {
			result.put("message", "失败");
			result.put("success", false);
			return GyUtils.returnResult(true, "成功", result);
		}
	}

	@Override
	public JSONObject bjGrxx(String param, HttpServletRequest request) {
		HttpSession session = request.getSession(true);

		String bh = (String) session.getAttribute("id");
		UserInfoEntity user = userInfoMapper.selectUserinfo(bh);
		JSONObject data = new JSONObject();
		JSONObject result = new JSONObject();
		if (user == null) {
			result.put("data", "");
			result.put("message", "无个人信息");
			result.put("success", false);
			return GyUtils.returnResult(true, "成功", result);
		}
		data.put("id", user.getId());
		data.put("sjhm", user.getSjhm());
		data.put("sfzhm", user.getSfzhm());
		data.put("tplj", user.getTplj());
		data.put("txzp", user.getTxzp());
		data.put("type", user.getType());
		data.put("xm", user.getXm());
		data.put("xxmc", user.getXxmc());
		data.put("zt", user.getZt());
		data.put("zymc", user.getZymc());
		data.put("email", user.getEmail());

		result.put("data", data);
		result.put("message", "成功");
		result.put("success", true);

		return GyUtils.returnResult(true, "成功", result);
	}

	@Override
	public JSONObject pl(String param, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String plrid = (String) session.getAttribute("id");
		String uuid = GyUtils.getUUid();
		JSONObject params = JSONObject.fromObject(param);
		String bq = params.getString("bq");
		int type = params.getInt("type");
		String nr = params.getString("nr");
		Date plsj = new Date();
		String jlid = params.getString("jlid");// type=1 简历id type=2 职位id
		String jobid = params.getString("jobid");
		String bplrid = new String();
		String grade = StringUtils.substring(params.getString("grade"), 0,
				params.getString("grade").length() - 1);
		// 对学生进行评论
		if (type == 1) {
			JianliEntity jianli = jianliMapper.selectPersonJianliByid(jlid);
			bplrid = jianli.getC_syzid();
		} else {
			JobInfoEntity job = jobMapper.selectJob(jobid);
			bplrid = job.getC_fbzid();
		}

		JSONObject result = new JSONObject();
		CommentEntity comment = userInfoMapper.selectComment(plrid, bplrid,
				jobid);
		if (comment != null) {
			result.put("message", "您已评论,请勿重复评论！");
			result.put("success", false);
			return GyUtils.returnResult(true, "成功", result);
		}

		int flag = userInfoMapper.insertComment(uuid, plrid, bplrid, bq, nr,
				plsj, jobid, grade);
		if (flag == 0) {
			result.put("message", "评价失败！");
			result.put("success", false);
			return GyUtils.returnResult(true, "成功", result);
		} else {
			result.put("message", "评价成功！");
			result.put("success", true);
			return GyUtils.returnResult(true, "成功", result);
		}
	}

	@Override
	public JSONObject sdpl(String param, HttpServletRequest request) {
		JSONObject params = JSONObject.fromObject(param);
		int zt = params.getInt("zt");
		HttpSession session = request.getSession(true);
		String bplrid = new String();
		if (zt == 1) {
			bplrid = (String) session.getAttribute("id");
		} else if (zt == 2) {
			String jlid = params.getString("jlid");
			JianliEntity jianli = jianliMapper.selectPersonJianliByid(jlid);
			bplrid = jianli.getC_syzid();
		}
		ArrayList<String> tjbq = new ArrayList<>();
		double pftj = 0;
		int pjrs = 0;
		List<CommentEntity> comments = userInfoMapper.selectMyComment(bplrid);
		JSONArray array = new JSONArray();
		JSONArray jsonArr = new JSONArray();
		for (CommentEntity com : comments) {
			JSONObject data = new JSONObject();
			String pjrid = com.getPjrid();
			UserInfoEntity user = userInfoMapper.selectUserinfo(pjrid);
			String pjrxm = user.getXm();// 评价人姓名
			String zp = user.getTxzp();// 评价人照片
			data.put("pjrxm", pjrxm);
			data.put("zp", zp);
			String bq = com.getBq();
			String[] bqlist = bq.split(",");// 标签数组
			for (String bqnr : bqlist) {
				tjbq.add(bqnr);
			}
			data.put("bq", bqlist);// 单人评价标签
			data.put("nr", com.getPjnr());// 评价内容
			pjrs++;
			pftj = pftj + Double.parseDouble(com.getGrade());

			array.add(data);
		}

		// 排序查出数量最多的前五个标签
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String str : tjbq) {
			int i = 1;
			if (map.get(str) != null) {
				i = map.get(str) + 1;
			}
			map.put(str, i);
		}

		Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();
		String txtAfterFormat = "";
		String[] fivebq = new String[5];
		ArrayList<JSONObject> allbq = new ArrayList<>();
		while (iter.hasNext()) {
			JSONObject data1 = new JSONObject();
			Entry<String, Integer> entry = iter.next();
			String key = (String) entry.getKey();
			int val = (Integer) entry.getValue();
			data1.put("key", key);
			data1.put("value", val);
			allbq.add(data1);
			jsonArr.add(data1);
			txtAfterFormat = txtAfterFormat + key + "_" + val + ";";
		}

		Collections.sort(allbq, new Comparator<JSONObject>() {
			// You can change "Name" with "ID" if you want to sort by ID
			private static final String KEY_NAME = "value";

			@Override
			public int compare(JSONObject a, JSONObject b) {
				int valA = 0;
				int valB = 0;

				try {
					valA = (int) a.get(KEY_NAME);
					valB = (int) b.get(KEY_NAME);
				} catch (JSONException e) {
					// do something
				}

				return valB - valA;
				// if you want to change the sort order, simply use the
				// following:
				// return -valA.compareTo(valB);
			}
		});
		JSONArray sortedJsonArray = new JSONArray();
		for (int i = 0; i < jsonArr.size(); i++) {
			sortedJsonArray.add(allbq.get(i));
		}

		JSONObject result = new JSONObject();
		pftj = pftj / pjrs;

		result.put("pjrs", pjrs);
		result.put("five", sortedJsonArray);
		result.put("result", array);
		result.put("pf", String.format("%.1f", pftj));
		result.put("success", true);
		result.put("message", "获取评论列表成功！");
		return GyUtils.returnResult(true, "成功", result);
	}

	@Override
	public JSONObject tjzw(String param, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String userid = (String) session.getAttribute("id");
		JianliEntity jianli = jianliMapper.selectPersonJianli(userid);
		JSONArray jsonArr = new JSONArray();
		JSONObject result = new JSONObject();
		if (jianli == null) {
			result.put("message", "先填写简历");
			result.put("success", false);
			return GyUtils.returnResult(true, "成功", result);
		}
		String qwzw = jianli.getC_qwzw();
		double sum = 0;
		double avg = 0;
		List<JobInfoEntity> jobs = jobMapper.selectTjzw(qwzw);
		if(jobs.size()==0){
			result.put("message", "没有推荐的职位");
			result.put("success", false);
			return GyUtils.returnResult(true, "成功", result);
		}
		ArrayList<JSONObject> allbq = new ArrayList<>();
		for (JobInfoEntity job : jobs) {
			List<CommentEntity> coms = userInfoMapper.selectByJobid(job
					.getC_id());
			if(coms.size()!=0){//有评论的时候推荐评论的里最好的
				int i = 0;
				for (CommentEntity com : coms) {
					sum = sum + Double.parseDouble(com.getGrade());
					i++;
					avg = sum / i;
				}
				JSONObject data = new JSONObject();
				data.put("key", job.getC_id());
				data.put("value", avg);
				sum = 0;
				allbq.add(data);
				jsonArr.add(data);
			}else{//推荐所有的
				JSONObject data = new JSONObject();
				data.put("key", job.getC_id());
				data.put("value", 1);
				allbq.add(data);
				jsonArr.add(data);
			}
		}
		Collections.sort(allbq, new Comparator<JSONObject>() {
			// You can change "Name" with "ID" if you want to sort by ID
			private static final String KEY_NAME = "value";

			@Override
			public int compare(JSONObject a, JSONObject b) {
				double valA = 0;
				double valB = 0;

				try {
					valA = Double.valueOf(a.get(KEY_NAME).toString());
					valB = Double.valueOf(b.get(KEY_NAME).toString());
				} catch (JSONException e) {
					// do something
				}
				return (int) Math.ceil(valB - valA);
				// if you want to change the sort order, simply use the
				// following:
				// return -valA.compareTo(valB);
			}
		});
		JSONArray sortedJsonArray = new JSONArray();
		for (int i = 0; i < jsonArr.size(); i++) {
			sortedJsonArray.add(allbq.get(i));
		}
		JSONArray jsonarray=new JSONArray();
		if(sortedJsonArray.size()>=5){
			for(int i=5;i>0;i--){
				JSONObject data=new JSONObject();
				JSONObject job=(JSONObject) sortedJsonArray.get(i);
				String jobid=job.getString("key");
				JobInfoEntity jobinfo=jobMapper.selectJob(jobid);
				data.put("zwmc", jobinfo.getC_zwmc());
				data.put("gzdz", jobinfo.getC_gzdz());
				data.put("jobid", jobinfo.getC_id());
				jsonarray.add(data);
			}			
		}else{
			for(int i=0;i<sortedJsonArray.size();i++){
				JSONObject data=new JSONObject();
				JSONObject job=(JSONObject) sortedJsonArray.get(i);
				String jobid=job.getString("key");
				JobInfoEntity jobinfo=jobMapper.selectJob(jobid);
				data.put("zwmc", jobinfo.getC_zwmc());
				data.put("gzdz", jobinfo.getC_gzdz());
				data.put("jobid", jobinfo.getC_id());
				jsonarray.add(data);
			}		
		}
		
		result.put("result", jsonarray);
		result.put("message", "获取推荐职位列表成功！");
		result.put("success", true);
		return GyUtils.returnResult(true, "成功", result);
	}

}
