package com.example.SpringBootCRUD.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ErrorMessage {
    private int statusCode;
    private String message;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorMessage(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
}