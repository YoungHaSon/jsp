package kr.or.ddit.user.model;

import java.lang.reflect.Constructor;

public class UserVo {

	private String name;
	private String userId;
	private String alias;
	private String pass;
	
	
	public UserVo(){
		//기본생성자
	}
	
	public UserVo(String name, String userId, String alias) {
		super();
		this.name = name;
		this.userId = userId;
		this.alias = alias;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "UserVo [name=" + name + ", userId=" + userId + ", alias="
				+ alias + ", pass=" + pass + "]";
	}

	
	
	
	
}
