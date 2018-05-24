package com.liyuan.po;

import java.util.Date;

public class JobInfoEntity {
	/**
	 * id
	 */
	String c_id;
	/**
	 * 职位类型
	 */
	int n_code;
	/**
	 * 职位名称
	 */
	String c_zwmc;
	/**
	 * 工作性质
	 */
	int n_gzxz;
	/**
	 * 月薪
	 */
	int n_yx;
	/**
	 * 工作经验
	 */
	int n_gzjy;
	/**
	 * 学历要求
	 */
	int n_xlyq;
	/**
	 * 职位描述
	 */
	String c_zwms;
	/**
	 * 工作地址
	 */
	String c_gzdz;
	/**
	 * 接收简历邮箱
	 */
	String c_jsjlyx;
	/**
	 * 浏览次数
	 */
	int n_llcs;
	/**
	 * 状态
	 */
	int n_zt;
	/**
	 * 发布时间
	 */
	Date dt_fbsj;
	/**
	 * 发布者id
	 */
	String c_fbzid;
	
	String c_jobtype3;
	
	String c_jobtype1;
	

	public String getC_jobtype1() {
		return c_jobtype1;
	}
	public void setC_jobtype1(String c_jobtype1) {
		this.c_jobtype1 = c_jobtype1;
	}
	public String getC_jobtype3() {
		return c_jobtype3;
	}
	public void setC_jobtype3(String c_jobtype3) {
		this.c_jobtype3 = c_jobtype3;
	}
	public String getC_fbzid() {
		return c_fbzid;
	}
	public void setC_fbzid(String c_fbzid) {
		this.c_fbzid = c_fbzid;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public int getN_code() {
		return n_code;
	}
	public void setN_code(int n_code) {
		this.n_code = n_code;
	}
	public String getC_zwmc() {
		return c_zwmc;
	}
	public void setC_zwmc(String c_zwmc) {
		this.c_zwmc = c_zwmc;
	}
	public int getN_gzxz() {
		return n_gzxz;
	}
	public void setN_gzxz(int n_gzxz) {
		this.n_gzxz = n_gzxz;
	}
	public int getN_yx() {
		return n_yx;
	}
	public void setN_yx(int n_yx) {
		this.n_yx = n_yx;
	}
	public int getN_gzjy() {
		return n_gzjy;
	}
	public void setN_gzjy(int n_gzjy) {
		this.n_gzjy = n_gzjy;
	}
	public int getN_xlyq() {
		return n_xlyq;
	}
	public void setN_xlyq(int n_xlyq) {
		this.n_xlyq = n_xlyq;
	}
	public String getC_zwms() {
		return c_zwms;
	}
	public void setC_zwms(String c_zwms) {
		this.c_zwms = c_zwms;
	}
	public String getC_gzdz() {
		return c_gzdz;
	}
	public void setC_gzdz(String c_gzdz) {
		this.c_gzdz = c_gzdz;
	}
	public String getC_jsjlyx() {
		return c_jsjlyx;
	}
	public void setC_jsjlyx(String c_jsjlyx) {
		this.c_jsjlyx = c_jsjlyx;
	}
	public int getN_llcs() {
		return n_llcs;
	}
	public void setN_llcs(int n_llcs) {
		this.n_llcs = n_llcs;
	}
	public int getN_zt() {
		return n_zt;
	}
	public void setN_zt(int n_zt) {
		this.n_zt = n_zt;
	}
	public Date getDt_fbsj() {
		return dt_fbsj;
	}
	public void setDt_fbsj(Date dt_fbsj) {
		this.dt_fbsj = dt_fbsj;
	}

}
