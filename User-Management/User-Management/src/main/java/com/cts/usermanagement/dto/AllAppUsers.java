package com.cts.usermanagement.dto;

import java.util.List;

import com.cts.usermanagement.model.AppUser;

public class AllAppUsers {
	List<AppUser> allAppUser;

	public List<AppUser> getAllAppUser() {
		return allAppUser;
	}

	public void setAllAppUser(List<AppUser> allAppUser) {
		this.allAppUser = allAppUser;
	}

	@Override
	public String toString() {
		return "AllAppUsers [allAppUser=" + allAppUser + "]";
	}

	
	
	
}
