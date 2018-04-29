package com.liyuan.mapper;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liyuan.po.BlackListEntity;
import com.liyuan.po.JubaoEntity;
import com.liyuan.po.ShenheEntity;

public interface AdminMapper {
	
	List<ShenheEntity> selectDsh();
	
	List<ShenheEntity> selectYsh();
	
	int updataTgsh(
			@Param("id")String id,
			@Param("shsj")Date shsj,
			@Param("zt")int zt
			);
	
	int deleteShxx(
			@Param("id")String id
			);
	
	List<JubaoEntity> selectDcl();
	
	List<JubaoEntity> selectYcl();
	
	int updateLh(
			@Param("id")String id,
			@Param("zt")int zt
			);
	
	int updateBysl(
			@Param("id")String id,
			@Param("zt")int zt
			);
	
	int insertBlackList(
			@Param("uuid")String uuid,
			@Param("yhid")String yhid,
			@Param("lhsj")Date lhsj,
			@Param("repoid")String repoid,
			@Param("lhyy")int lhyy
			);
	
	int deleteJbxx(
			@Param("id")String id
			);
	
	List<BlackListEntity> selectBlacklist();
	
	int delectBlacklist(
			@Param("id")String id
			);
}
