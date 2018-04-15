package com.liyuan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyuan.po.Upfile;
import com.liyuan.service.UpfileService;

/**
 * 用户Controller*/
@Controller
public class UpfileController {

	@Autowired
	private UpfileService upfileService;
	//登录
	@RequestMapping("/upfile")
	@ResponseBody public Upfile upfile() throws Exception{
		System.out.println("sasaassasasa");
		return upfileService.findById("0ceba96c-dba8-4581-896d-95032b70db53");
	}	
}
