package com.liyuan.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liyuan.mapper.AdminMapper;
import com.liyuan.po.BlackListEntity;
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
		JSONObject params=JSONObject.fromObject(param);
		//页面大小
		int pagesize=params.getInt("pagesize");
		//页面
		int page=params.getInt("page");
		Integer offset=(page-1)*pagesize;
		List<ShenheEntity> dshlist=adminMapper.selectDsh(pagesize,offset);
		long number=adminMapper.selectDshNumber();
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
		Integer totalPageNumber=(int)Math.ceil((double)number/pagesize);
		result.put("sum", number);
		result.put("totalpage", totalPageNumber);
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
		JSONObject params=JSONObject.fromObject(param);
		//页面大小
		int pagesize=params.getInt("pagesize");
		//页面
		int page=params.getInt("page");
		Integer offset=(page-1)*pagesize;
		List<ShenheEntity> dshlist=adminMapper.selectYsh(pagesize,offset);
		long number=adminMapper.selectYshNumber();
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
		Integer totalPageNumber=(int)Math.ceil((double)number/pagesize);
		result.put("sum", number);
		result.put("totalpage", totalPageNumber);
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
		JSONObject params=JSONObject.fromObject(param);
		//页面大小
		int pagesize=params.getInt("pagesize");
		//页面
		int page=params.getInt("page");
		Integer offset=(page-1)*pagesize;
		List<JubaoEntity> dclList=adminMapper.selectDcl(pagesize,offset);
		long number=adminMapper.selectDclNumber();
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
		Integer totalPageNumber=(int)Math.ceil((double)number/pagesize);
		result.put("sum", number);
		result.put("totalpage", totalPageNumber);
		return GyUtils.returnResult(true, "成功", result);
	}

	@Override
	public JSONObject ycljbService(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		//页面大小
		int pagesize=params.getInt("pagesize");
		//页面
		int page=params.getInt("page");
		Integer offset=(page-1)*pagesize;
		List<JubaoEntity> yclList=adminMapper.selectYcl(pagesize,offset);
		long number=adminMapper.selectYclNumber();
		JSONArray jsonArray=new JSONArray();
		for(JubaoEntity dcl:yclList){
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
		Integer totalPageNumber=(int)Math.ceil((double)number/pagesize);
		result.put("sum", number);
		result.put("totalpage", totalPageNumber);
		return GyUtils.returnResult(true, "成功", result);
	}

	@Override
	public JSONObject lhService(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		String id=params.getString("id");
		String bjbrid=params.getString("bjbrid");
		String uuid=GyUtils.getUUid();
		int lhyy=params.getInt("jblx");
		Date lhsj=new Date();
		int zt=2;
		int flag=adminMapper.updateLh(id, zt);
		JSONObject result=new JSONObject();
		if(flag!=1){
			result.put("success", false);
			result.put("message", "失败");
			return GyUtils.returnResult(true, "成功", result);
		}else{
			int flag2=adminMapper.insertBlackList(uuid, bjbrid, lhsj, id , lhyy);
			if(flag2!=1){
				result.put("success", false);
				result.put("message", "失败");
				return GyUtils.returnResult(true, "成功", result);
			}else{
				result.put("success", true);
				result.put("message", "成功");
				return GyUtils.returnResult(true, "成功", result);
			}
		}
	}

	@Override
	public JSONObject byslService(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		String id=params.getString("id");
		int zt=3;
		int flag=adminMapper.updateBysl(id, zt);
		
		JSONObject result=new JSONObject();
		if(flag!=1){
			result.put("success", false);
			result.put("message", "失败");
			return GyUtils.returnResult(true, "成功", result);
		}else{
			result.put("success", true);
			result.put("message", "成功");
			return GyUtils.returnResult(true, "成功", result);
		}
	}

	@Override
	public JSONObject scjbxxService(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		String id=params.getString("id");
		int flag=adminMapper.deleteJbxx(id);
		JSONObject result=new JSONObject();
		if(flag!=1){
			result.put("success", false);
			result.put("message", "删除失败");
			return GyUtils.returnResult(true, "成功", result);
		}else{
			result.put("success", true);
			result.put("message", "删除成功");
			return GyUtils.returnResult(true, "成功", result);
		}
	}

	@Override
	public JSONObject blackListService(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		//页面大小
		int pagesize=params.getInt("pagesize");
		//页面
		int page=params.getInt("page");
		Integer offset=(page-1)*pagesize;
		
		List<BlackListEntity> blacklist=adminMapper.selectBlacklist(pagesize, offset);
		long number=adminMapper.selectBlacklistNumber();
		
		JSONArray jsonArray=new JSONArray();
		for(BlackListEntity black:blacklist){
			JSONObject data=new JSONObject();
			
			data.put("id", black.getId());
			data.put("yhid", black.getYhid());
			data.put("lhsj", GyUtils.dateTostring(black.getLhsj()));
			data.put("repoid", black.getRepoid());
			data.put("username", black.getUsername());
			data.put("lhyy", black.getLhyy());
			jsonArray.add(data);
		}
		
		JSONObject result=new JSONObject();
		result.put("data", jsonArray);
		result.put("success", true);
		Integer totalPageNumber=(int)Math.ceil((double)number/pagesize);
		result.put("sum", number);
		result.put("totalpage", totalPageNumber);
		result.put("message", "获取黑名单成功");
		
		return GyUtils.returnResult(true, "成功", result);
	}

	@Override
	public JSONObject hfyhService(String param, HttpServletRequest request) {
		JSONObject params=JSONObject.fromObject(param);
		String id=params.getString("id");
		String reportid=params.optString("repoid");
		JSONObject result=new JSONObject();
		if(!StringUtils.isBlank(reportid)){
			int flag1=adminMapper.delectBlacklist(id);
			if(flag1!=1){
				result.put("success", false);
				result.put("message", "删除失败");
				return GyUtils.returnResult(true, "成功", result);
			}else{
				int flag=adminMapper.deleteJbxx(reportid);
				if(flag!=1){
					result.put("success", false);
					result.put("message", "删除失败");
					return GyUtils.returnResult(true, "成功", result);
				}else{
					result.put("success", true);
					result.put("message", "删除成功");
					return GyUtils.returnResult(true, "成功", result);
				}
			}
		}else{
			int flag1=adminMapper.delectBlacklist(id);
			if(flag1!=1){
				result.put("success", false);
				result.put("message", "删除失败");
				return GyUtils.returnResult(true, "成功", result);
			}else{
				result.put("success", true);
				result.put("message", "删除成功");
				return GyUtils.returnResult(true, "成功", result);
			}
		}
	}

}
