package com.cts.productmanagement.model;

public class JwtResponse {

	//private String userid;

	//private String username;

	private boolean isValid;

	/*public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}*/

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public JwtResponse() {
		super();	
	}

	public JwtResponse( boolean isValid) {
        super();
		this.isValid = isValid;
	}

}
