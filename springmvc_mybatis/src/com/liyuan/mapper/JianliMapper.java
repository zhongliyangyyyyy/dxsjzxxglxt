package com.liyuan.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.liyuan.po.JianliEntity;

public interface JianliMapper {
	
	JianliEntity selectPersonJianli(
			@Param("c_id")String c_id
			);
	
	int updateJianli(
			@Param("c_id")String c_id,
			@Param("c_name")String c_name,
			@Param("n_xb")int n_xb,
			@Param("c_sjhm")String c_sjhm,
			@Param("c_yx")String c_yx,
			@Param("c_qwgzdz")String c_qwgzdz,
			@Param("n_gzxz")int n_gzxz,
			@Param("c_qwzw")String c_qwzw,
			@Param("n_qwyx")int n_qwyx,
			@Param("c_gsmc")String c_gsmc,
			@Param("c_zwmc")String c_zwmc,
			@Param("c_xxmc")String c_xxmc,
			@Param("n_gzjy")int n_gzjy,
			@Param("n_xl")int n_xl,
			@Param("c_zymc")String c_zymc,
			@Param("dt_kssj")Date dt_kssj,
			@Param("dt_jssj")Date dt_jssj,
			@Param("c_zwms")String c_zwms,
			@Param("c_jlmc")String c_jlmc,
			@Param("c_zp")String c_zp,
			@Param("n_xxxl")int n_xxxl
			);
	
	int insertJianli(
			@Param("c_id")String c_id,
			@Param("c_name")String c_name,
			@Param("n_xb")int n_xb,
			@Param("c_sjhm")String c_sjhm,
			@Param("c_yx")String c_yx,
			@Param("c_qwgzdz")String c_qwgzdz,
			@Param("n_gzxz")int n_gzxz,
			@Param("c_qwzw")String c_qwzw,
			@Param("n_qwyx")int n_qwyx,
			@Param("c_gsmc")String c_gsmc,
			@Param("c_zwmc")String c_zwmc,
			@Param("c_xxmc")String c_xxmc,
			@Param("n_gzjy")int n_gzjy,
			@Param("n_xl")int n_xl,
			@Param("c_zymc")String c_zymc,
			@Param("dt_kssj")Date dt_kssj,
			@Param("dt_jssj")Date dt_jssj,
			@Param("c_zwms")String c_zwms,
			@Param("c_jlmc")String c_jlmc,
			@Param("c_zp")String c_zp,
			@Param("c_syzid")String c_syzid,
			@Param("n_xxxl")int n_xxxl
			);
}
