package com.cts.usermanagement.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppUser {
	@Column(unique=true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique=true,nullable=false)
	private String userName;
	@Column(nullable=false)
	private String password;
	@Column(unique=true,nullable=false)
	private Long mobile;
	@Column(nullable=false)
	private String mailId;
	@Column(nullable=false)
	private Date redgDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	
	
	/*public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}*/

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

