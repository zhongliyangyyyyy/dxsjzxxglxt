package com.liyuan.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liyuan.po.CommentEntity;
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
	
	int updateType(
			@Param("type")int type,
			@Param("id")String id
			);
	
	int updateZp(
			@Param("id")String id,
			@Param("zp")String zp
			);
	
	int insertComment(
			@Param("uuid")String uuid,
			@Param("pjrid")String pjrid,
			@Param("bpjrid")String bpjrid,
			@Param("bq")String bq,
			@Param("pjnr")String pjnr,
			@Param("pjsj")Date pjsj,
			@Param("jobid")String jobid,
			@Param("grade")String grade
			);
	
	CommentEntity selectComment(
			@Param("pjrid")String pjrid,
			@Param("bpjrid")String bpjrid,
			@Param("jobid")String jobid
			);
	
	List<CommentEntity> selectMyComment(
			@Param("bpjrid")String bpjrid
			);
	
	List<CommentEntity> selectByJobid(
			@Param("jobid")String jobid
			);
}
