package com.booking.api.responses;

import java.io.Serializable;

public class BookingResponse<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private String status;
	private String conde;
	private String message;
	private T data;
	public BookingResponse(String status, String conde, String message) {

		this.status = status;
		this.conde = conde;
		this.message = message;
	}
	
	public BookingResponse(String status, String conde, String message, T data) {

		this.status = status;
		this.conde = conde;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getConde() {
		return conde;
	}

	public void setConde(String conde) {
		this.conde = conde;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	

}
