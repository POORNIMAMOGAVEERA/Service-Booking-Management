package com.cts.jwt.api.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppUser {

	@Id
	private Integer id;
	private String userName;
	private String password;
	private Long mobile;
	private String mailId;
	private Date redgDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getmailId() {
		return mailId;
	}

	public void setmailId(String mailId) {
		this.mailId = mailId;
	}

	public Date getRedgDate() {
		return redgDate;
	}

	public void setRedgDate(Date redgDate) {
		this.redgDate = redgDate;
	}

}

