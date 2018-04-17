package com.liyuan.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liyuan.po.JobInfoEntity;
import com.liyuan.po.JobTypeEntity;
import com.sun.org.glassfish.gmbal.ParameterNames;

public interface JobMapper {
	
	List<JobTypeEntity> selectJobtype();
	
	/**
	 * 创建职位
	 */
	int insertJobinfi(
			@Param("n_code")int n_code,
			@Param("c_zwmc")String c_zwmc,
			@Param("n_gzxz")int n_gzxz,
			@Param("n_yx")int n_yx,
			@Param("n_gzjy")int n_gzjy,
			@Param("n_xlyq")int n_xlyq,
			@Param("c_zwms")String c_zwms,
			@Param("c_gzdz")String c_gzdz,
			@Param("c_jsjlyx")String c_jsjlyx,
			@Param("dt_fbsj")Date dt_fbsj,
			@Param("n_zt")int n_zt,
			@Param("c_id")String c_id,
			@Param("c_fbzid")String c_fbzid
			);
	
	JobInfoEntity selectJob(
			@Param("c_id")String c_id
			);
	
	List<JobInfoEntity> selectHotJob();
	
	List<JobInfoEntity> selectNewJob();
	
	List<JobInfoEntity> selectSearchJob(
			@Param("c_nr")String c_nr,
			@Param("n_yxstart")int n_yxstart,
			@Param("n_yxend")int n_yxend,
			@Param("n_gzjy")int n_gzjy,
			@Param("n_xlyq")int n_xlyq,
			@Param("n_gzxz")int n_gzxz,
			@Param("dt_fbsj")Date dt_fbsj,
			@Param("pagesize")int pagesize,
			@Param("offset")Integer offset
			);
	
	long selectSearchJobNumber(
			@Param("c_nr")String c_nr,
			@Param("n_yxstart")int n_yxstart,
			@Param("n_yxend")int n_yxend,
			@Param("n_gzjy")int n_gzjy,
			@Param("n_xlyq")int n_xlyq,
			@Param("n_gzxz")int n_gzxz,
			@Param("dt_fbsj")Date dt_fbsj
			);
}
