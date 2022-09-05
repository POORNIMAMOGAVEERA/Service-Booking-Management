package com.CTS.serviceBookingManagement.model;

public class JwtResponse {
	private boolean isValid;

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public JwtResponse(boolean isValid) {
		super();
		this.isValid = isValid;
	}

	public JwtResponse() {
		super();
	}
}
