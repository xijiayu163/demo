package com.yu.dubbo.entity;

public class User {
	private String accountUid;
    private String userPassword;
    private String userName;
    private Integer age;
    private String company;
    
	public final String getAccountUid() {
		return accountUid;
	}
	public final void setAccountUid(String accountUid) {
		this.accountUid = accountUid;
	}
	public final String getUserPassword() {
		return userPassword;
	}
	public final void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public final String getUserName() {
		return userName;
	}
	public final void setUserName(String userName) {
		this.userName = userName;
	}
	public final Integer getAge() {
		return age;
	}
	public final void setAge(Integer age) {
		this.age = age;
	}
	public final String getCompany() {
		return company;
	}
	public final void setCompany(String company) {
		this.company = company;
	}
}
