package com.tt.exam.examinee.bean;

public class Examinee {

	private String id;
	private String account;
	private String password;
	private String name;

	public Examinee() {
		// do nothing
	}

	public Examinee(String id, String account, String password, String name) {
		this.id = id;
		this.account = account;
		this.password = password;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

}
