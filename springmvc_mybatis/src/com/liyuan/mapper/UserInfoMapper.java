package com.liyuan.mapper;

import org.apache.ibatis.annotations.Param;

import com.liyuan.po.UserInfoEntity;

public interface UserInfoMapper {
	int insertUserinfo(
			@Param("c_id")String c_id,
			@Param("c_sfzhm")String c_sfzhm,
			@Param("c_sjhm")String c_sjhm,
			@Param("c_tplj")String c_tplj,
			@Param("c_txzp")String c_txzp,
			@Param("c_type")int n_type,
			@Param("c_xm")String c_xm,
			@Param("c_xxmc")String c_xxmc,
			@Param("c_zymc")String c_zymc,
			@Param("c_bh")String c_bh
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
