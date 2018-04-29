package com.liyuan.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyuan.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	/**
	 * 待审核列表
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dshlb",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject dshlbController(@RequestBody String param,HttpServletRequest request){
		return adminService.dshlbService(param, request);
	}
	
	/**
	 * 已审核列表
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/yshlb",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject yshlbController(@RequestBody String param,HttpServletRequest request){
		return adminService.yshlbService(param, request);
	}
	
	/**
	 * 待处理举报
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dcljblist",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject dcljbController(@RequestBody String param,HttpServletRequest request){
		return null;
	}
	
	/**
	 * 已处理举报
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dcljb",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject ycljbController(@RequestBody String param,HttpServletRequest request){
		return null;
	}
	
	/**
	 * 黑名单列表
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/blacklist",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject blackListController(@RequestBody String param,HttpServletRequest request){
		return null;
	}
	
	/**
	 * 审核通过
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/shtg",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject shtgController(@RequestBody String param,HttpServletRequest request){
		return adminService.shtgService(param, request);
	}
	
	/**
	 * 审核不通过
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/shbtg",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject shbtgController(@RequestBody String param,HttpServletRequest request){
		return adminService.shbtgService(param, request);
	}
	
	/**
	 * 删除审核信息
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/scshxx",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject scshxxController(@RequestBody String param,HttpServletRequest request){
		return null;
	}
	
	/**
	 * 拉黑
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/lh",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject lhController(@RequestBody String param,HttpServletRequest request){
		return null;
	}
	
	/**
	 * 不予受理
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/bysl",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject byslController(@RequestBody String param,HttpServletRequest request){
		return null;
	}
	
	/**
	 * 删除举报信息
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/scjbxx",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject scjbxxController(@RequestBody String param,HttpServletRequest request){
		return null;
	}
	
	/**
	 * 恢复用户
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/hfyh",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject hfyhController(@RequestBody String param,HttpServletRequest request){
		return null;
	}
}
