package com.liyuan.po;

import java.util.Date;

public class ReceJianliEntity {
	
	/**
	 * id
	 */
	String c_id;
	
	/**
	 * 简历名称
	 */
	String c_jlmc;
	
	/**
	 * 姓名
	 */
	String c_name;
	
	/**
	 * 性别
	 */
	int n_xb;
	
	/**
	 * 学历
	 */
	int n_xl;
	
	/**
	 * 毕业院校
	 */
	String c_byxx;
	
	/**
	 * 专业
	 */
	String c_zy;
	
	/**
	 * 应聘职位
	 */
	String c_ypzw;
	
	/**
	 * 投递时间
	 */
	Date dt_tdsj;
	
	/**
	 * 简历id
	 */
	String c_jlid;
	
	String jobid;
	
	String gzdz;
	
	int zt;
	
	String qwgzdz;
	
	String zp;
	
	int gzjy;
	
	
	public int getGzjy() {
		return gzjy;
	}

	public void setGzjy(int gzjy) {
		this.gzjy = gzjy;
	}

	public String getQwgzdz() {
		return qwgzdz;
	}

	public void setQwgzdz(String qwgzdz) {
		this.qwgzdz = qwgzdz;
	}

	public void setZp(String zp) {
		this.zp = zp;
	}

	public String getZp() {
		return zp;
	}

	public String getGzdz() {
		return gzdz;
	}

	public void setGzdz(String gzdz) {
		this.gzdz = gzdz;
	}

	public int getZt() {
		return zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String getC_jlid() {
		return c_jlid;
	}

	public void setC_jlid(String c_jlid) {
		this.c_jlid = c_jlid;
	}

	public String getC_jlmc() {
		return c_jlmc;
	}

	public void setC_jlmc(String c_jlmc) {
		this.c_jlmc = c_jlmc;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getN_xb() {
		return n_xb;
	}

	public void setN_xb(int n_xb) {
		this.n_xb = n_xb;
	}

	public int getN_xl() {
		return n_xl;
	}

	public void setN_xl(int n_xl) {
		this.n_xl = n_xl;
	}

	public String getC_byxx() {
		return c_byxx;
	}

	public void setC_byxx(String c_byxx) {
		this.c_byxx = c_byxx;
	}

	public String getC_zy() {
		return c_zy;
	}

	public void setC_zy(String c_zy) {
		this.c_zy = c_zy;
	}

	public String getC_ypzw() {
		return c_ypzw;
	}

	public void setC_ypzw(String c_ypzw) {
		this.c_ypzw = c_ypzw;
	}

	public Date getDt_tdsj() {
		return dt_tdsj;
	}

	public void setDt_tdsj(Date dt_tdsj) {
		this.dt_tdsj = dt_tdsj;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	
}
