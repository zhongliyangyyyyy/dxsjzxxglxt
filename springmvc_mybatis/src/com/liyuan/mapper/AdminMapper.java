package com.liyuan.mapper;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liyuan.po.ShenheEntity;

public interface AdminMapper {
	
	List<ShenheEntity> selectDsh();
	
	List<ShenheEntity> selectYsh();
	
	int updataTgsh(
			@Param("id")String id,
			@Param("shsj")Date shsj,
			@Param("zt")int zt
			);
}
