package com.springbook.biz.user;

public class UserVO { // VO = value object
	// private으로 하고, set,get으로만 접근/수정 가능!
	private String id;
	private String password;
	private String name;
	private String role;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override // 이것도 alt+shift+s -> toString으로 만들 수 있음
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}
}
