package com.sk.ecom.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Shesho
 */

public class ExceptionDetail {
	
	@JsonProperty("status")
	private String status = null;

	@JsonProperty("error")
	private String error = null;

	@JsonProperty("message")
	private String message = null;
	
	@JsonProperty("path")
	private String path = null;

	public ExceptionDetail(String status, String error, String message, String path) {
		super();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
