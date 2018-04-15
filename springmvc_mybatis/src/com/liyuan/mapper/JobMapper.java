package com.liyuan.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liyuan.po.JobTypeEntity;

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
}
