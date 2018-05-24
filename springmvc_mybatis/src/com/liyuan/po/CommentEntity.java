package com.liyuan.po;

import java.util.Date;

public class CommentEntity {
	String id;
	
	String pjrid;
	
	String bpjrid;
	
	String bq;
	
	String pjnr;
	
	Date pjsj;
	
	String jobid;
	
	String grade;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPjrid() {
		return pjrid;
	}

	public void setPjrid(String pjrid) {
		this.pjrid = pjrid;
	}

	public String getBpjrid() {
		return bpjrid;
	}

	public void setBpjrid(String bpjrid) {
		this.bpjrid = bpjrid;
	}

	public String getBq() {
		return bq;
	}

	public void setBq(String bq) {
		this.bq = bq;
	}

	public String getPjnr() {
		return pjnr;
	}

	public void setPjnr(String pjnr) {
		this.pjnr = pjnr;
	}

	public Date getPjsj() {
		return pjsj;
	}

	public void setPjsj(Date pjsj) {
		this.pjsj = pjsj;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	
}
