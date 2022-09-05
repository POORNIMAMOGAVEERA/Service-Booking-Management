package com.cts.jwt.api.entity;

import java.util.List;


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
