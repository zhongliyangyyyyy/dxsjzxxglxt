package com.liyuan.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyuan.service.JianliService;

@Controller
public class JianliController {
	
	@Autowired JianliService jianliService;
	
	/**
	 * 查看，编辑简历
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/ckjianli", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject ckJianli(HttpServletRequest request){
		return jianliService.personJianli(request);
	}
	
	/**
	 * 保存简历
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/bcjianli", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject bcJianli(@RequestBody String param,HttpServletRequest request){
		return jianliService.bcJianli(param, request);
	}
	
	/**
	 * 待处理简历
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dclJianli",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject dclJianli(@RequestBody String param,HttpServletRequest request){
		return jianliService.dclJianli(param, request);
	}
	
	/**
	 * 待定简历
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/ddJianli",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject ddJianli(@RequestBody String param,HttpServletRequest request){
		return jianliService.ddJianli(param, request);
	}
	
	/**
	 * 已通知面试简历
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/ytzmsJianli",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject ytzmsJianli(@RequestBody String param,HttpServletRequest request){
		return jianliService.ytzmsJianli(param, request);
	}
	
	/**
	 * 不合适简历
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/bhsJianli",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject bhsJianli(@RequestBody String param,HttpServletRequest request){
		return jianliService.bhsJianli(param, request);
	}
	
	/**
	 * 通过面试简历
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/tgmsJianli",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject tgmsJianli(@RequestBody String param,HttpServletRequest request){
		return jianliService.tgmsJianli(param, request);
	}
	
	/**
	 * 已投递简历列表
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/ytdJianli",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject ytdJianli(@RequestBody String param,HttpServletRequest request){
		return jianliService.ytdJianli(param, request);
	}
	
	/**
	 * 投递简历
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/tdJianli",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject tdJianli(@RequestBody String param,HttpServletRequest request){
		return jianliService.tdJianli(param, request);
	}
	
	/**
	 * 设置按钮
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/setbutton",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject setBhs(@RequestBody String param,HttpServletRequest request){
		JSONObject params=JSONObject.fromObject(param);
		int n_type=params.getInt("type");
		if(n_type==1){
			return jianliService.setBhs(param, request);
		}else if(n_type==2){
			return jianliService.setDd(param, request);
		}else if(n_type==3){
			return jianliService.setTzms(param, request);
		}else if(n_type==4){
			return jianliService.setTgms(param, request);
		}else if(n_type==5){
			return jianliService.deletJl(param, request);
		}else{
			return null;
		}
		
	}
	
	/**
	 * 查看简历
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/ckjianlibyid",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject ckJianli(@RequestBody String param,HttpServletRequest request){
		return jianliService.ckJianli(param,request);
	}
}	 
