package com.example.JAVA.Spring.conststants;

public enum RtnCode {
	SUCCESSFUL("200", "Successful!!!"),
	CANNOT_EMPTY("400","Data is blank"),
	DATE_ERROR("400","Data is error!"),
	NOT_FOUND("404", "Not Found!");
	
	
	
	

	private String code;

	private String message;

	private RtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

