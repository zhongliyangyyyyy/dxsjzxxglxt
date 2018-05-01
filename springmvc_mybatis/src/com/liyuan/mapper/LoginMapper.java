package com.liyuan.mapper;

import org.apache.ibatis.annotations.Param;

import com.liyuan.po.LoginEntity;

public interface LoginMapper {
	public LoginEntity selectUser(
			@Param("email")String email
			);
	public int insertUser(
			@Param("email")String email,
			@Param("password")String password,
			@Param("uuid")String uuid
			);
	
	public int selectUserInfo(
			@Param("bh")String bh
			);
	
	public LoginEntity selectUser1(
			@Param("email")String email
			);
}
