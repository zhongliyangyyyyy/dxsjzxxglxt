package com.liyuan.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liyuan.po.JobInfoEntity;
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
			@Param("c_fbzid")String c_fbzid,
			@Param("n_yxzt")int n_yxzt
			);
	
	/**
	 * 获取job基本信息
	 * @param c_id
	 * @return
	 */
	JobInfoEntity selectJob(
			@Param("c_id")String c_id
			);
	
	/**
	 * 获取最热职位列表
	 * @return
	 */
	List<JobInfoEntity> selectHotJob();
	
	/**
	 * 获取最新职位列表
	 * @return
	 */
	List<JobInfoEntity> selectNewJob();
	
	/**
	 * 搜索职位，职位列表（含表头过滤）
	 * @param c_nr
	 * @param n_yxstart
	 * @param n_yxend
	 * @param n_gzjy
	 * @param n_xlyq
	 * @param n_gzxz
	 * @param dt_fbsj
	 * @param pagesize
	 * @param offset
	 * @return
	 */
	List<JobInfoEntity> selectSearchJob(
			@Param("fbsj")int fbsj,
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
	
	/**
	 * 分页数量
	 * @param c_nr
	 * @param n_yxstart
	 * @param n_yxend
	 * @param n_gzjy
	 * @param n_xlyq
	 * @param n_gzxz
	 * @param dt_fbsj
	 * @return
	 */
	long selectSearchJobNumber(
			@Param("fbsj")int fbsj,
			@Param("c_nr")String c_nr,
			@Param("n_yxstart")int n_yxstart,
			@Param("n_yxend")int n_yxend,
			@Param("n_gzjy")int n_gzjy,
			@Param("n_xlyq")int n_xlyq,
			@Param("n_gzxz")int n_gzxz,
			@Param("dt_fbsj")Date dt_fbsj
			);
	
	
	/**
	 * 获取有效职位列表
	 * @param c_fbzid
	 * @return
	 */
	List<JobInfoEntity> selectyxJob(
			@Param("c_fbzid")String c_fbzid
			);
	
	/**
	 * 获取无效job列表
	 * @param c_fbzid
	 * @return
	 */
	List<JobInfoEntity> selectwxJob(
			@Param("c_fbzid")String c_fbzid
			);
	
	/**
	 * 下线job
	 * @param c_id
	 * @return
	 */
	int updateXxJob(
			@Param("c_id")String c_id
			);
	
	/**
	 * 上线job
	 * @param c_id
	 * @return
	 */
	int updateSxJob(
			@Param("c_id")String c_id
			);
	
	/**
	 * 删除job
	 * @param c_id
	 * @return
	 */
	int deleteJob(
			@Param("c_id")String c_id
			);
	
	/**
	 * 获取我收藏职位列表
	 * @param c_userid
	 * @return
	 */
	List<JobInfoEntity> selectWscJob(
			@Param("c_userid")String c_userid
			);
	
	/**
	 * 收藏职位按钮
	 * @param c_id
	 * @param c_userid
	 * @param c_jobid
	 * @return
	 */
	int insertWscJob(
			@Param("c_id")String c_id,
			@Param("c_userid")String c_userid,
			@Param("c_jobid")String c_jobid
			);
	
	/**
	 * 取消收藏按钮
	 * @param c_userid
	 * @param c_jobid
	 * @return
	 */
	int deleteWscJob(
			@Param("c_userid")String c_userid,
			@Param("c_jobid")String c_jobid
			);
	
	int insertShenhe(
			@Param("uuid")String uuud,
			@Param("shlx")int shlx,
			@Param("fqsj")Date fasj,
			@Param("zt")int zt,
			@Param("jlid")String jlid
			);
}
