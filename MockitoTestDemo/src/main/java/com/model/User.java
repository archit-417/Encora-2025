package com.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	private String username;
	private String password;
	private int flag;
		
	public User() {}
	
	public User(int userid, String username) {
		this.username = username;
		this.userid = userid;
	}
	
	public User(String username, String password) {
		this.username = username;
		this.flag = 0;
		this.password = password;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return userid == other.userid;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", flag=" + flag + "]";
	}
	
	
	
}

