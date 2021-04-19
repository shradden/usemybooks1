package com.shradden.usemybooks.models;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="users")
public class User {
	@Id
	private int userid;
	private String name;
	private String username;
	private String password;
	private String phone;
	private String email;
	public User() {}
	public User(int userid, String name, String username, String password, String phone, String email) {
		super();
		this.userid = userid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
