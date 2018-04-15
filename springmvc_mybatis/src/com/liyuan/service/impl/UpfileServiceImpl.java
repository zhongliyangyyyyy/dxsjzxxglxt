package com.liyuan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.liyuan.mapper.UpfileMapper;
import com.liyuan.po.Upfile;
import com.liyuan.service.UpfileService;

public class UpfileServiceImpl implements UpfileService{
	
	@Autowired
	private UpfileMapper upfileMapper;

	@Override
	public Upfile findById(String id) {
		// TODO Auto-generated method stub
		return upfileMapper.getById(id);
	}

}
