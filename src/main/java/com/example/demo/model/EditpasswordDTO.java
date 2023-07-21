package com.example.demo.model;

public class EditpasswordDTO {
	private String passwordold;
	private String passwordnew;

	public String getPasswordold() {
		return passwordold;
	}

	public void setPasswordold(String passwordold) {
		this.passwordold = passwordold;
	}

	public String getPasswordnew() {
		return passwordnew;
	}

	public void setPasswordnew(String passwordnew) {
		this.passwordnew = passwordnew;
	}

	public EditpasswordDTO(String passwordold, String passwordnew) {
		super();
		this.passwordold = passwordold;
		this.passwordnew = passwordnew;
	}

}
