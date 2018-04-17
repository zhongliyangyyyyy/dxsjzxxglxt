package com.liyuan.mapper;

import org.apache.ibatis.annotations.Param;

import com.liyuan.po.JianliEntity;

public interface JianliMapper {
	JianliEntity selectPersonJianli(
			@Param("c_id")String c_id
			);
}
