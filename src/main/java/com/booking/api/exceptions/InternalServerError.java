package com.booking.api.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.booking.api.dtos.ErrorDto;

public class InternalServerError extends BookingException{
	

	private static final long serialVersionUID = 1L;

	public InternalServerError(String code, String message) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
 
	}
	
	public InternalServerError(String code, String message, ErrorDto data) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
 
	}

}
