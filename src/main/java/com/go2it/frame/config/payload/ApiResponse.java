package com.go2it.frame.config.payload;

/**
 * This class should be used if the data in ResponseEntity contains message and status
 * Otherwise, use simple ResponseEntity
 *
 * @author Alex Ryzhkov
 */
public class ApiResponse {
	private Boolean isSuccess;
	private String message;

	public ApiResponse(Boolean isSuccess, String message) {
		this.isSuccess = isSuccess;
		this.message = message;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
