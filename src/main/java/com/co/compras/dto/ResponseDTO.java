package com.co.compras.dto;

public class ResponseDTO {
	
	private int httpStatus;
	
	private String message;
	
	private String code;
	
	private String backendMessage;

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBackendMessage() {
		return backendMessage;
	}

	public void setBackendMessage(String backendMessage) {
		this.backendMessage = backendMessage;
	}

	@Override
	public String toString() {
		return "ResponseDTO [httpStatus=" + httpStatus + ", message=" + message + ", code=" + code + ", backendMessage="
				+ backendMessage + "]";
	}
	
	

}
