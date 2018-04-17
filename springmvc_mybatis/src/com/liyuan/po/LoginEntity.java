package com.liyuan.po;

public class LoginEntity {
	
	/**
	 * 邮箱
	 */
	String email;
	
	/**
	 * 密码
	 */
	String password;
	
	/**
	 * 用户类型
	 */
	int type;
	
	/**
	 * 记录id
	 */
	String id;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
