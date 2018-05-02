package com.liyuan.mapper;

import org.apache.ibatis.annotations.Param;

import com.liyuan.po.UserInfoEntity;

public interface UserInfoMapper {
	int insertUserinfo(
			@Param("id")String id,
			@Param("sfzhm")String sfzhm,
			@Param("sjhm")String sjhm,
			@Param("tplj")String tplj,
			@Param("txzp")String txzp,
			@Param("type")int type,
			@Param("xm")String xm,
			@Param("xxmc")String xxmc,
			@Param("zymc")String zymc,
			@Param("bh")String bh
			);
	
	int updateUserinfo(
			@Param("id")String id,
			@Param("sfzhm")String sfzhm,
			@Param("sjhm")String sjhm,
			@Param("tplj")String tplj,
			@Param("txzp")String txzp,
			@Param("type")int type,
			@Param("xm")String xm,
			@Param("xxmc")String xxmc,
			@Param("zymc")String zymc
			);
	
	UserInfoEntity selectUserinfo(
			@Param ("bh")String bh
			);
}
