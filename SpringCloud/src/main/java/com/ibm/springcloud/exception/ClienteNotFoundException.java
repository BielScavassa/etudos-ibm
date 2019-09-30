package com.ibm.springcloud.exception;

import java.util.Date;

import feign.Request.HttpMethod;
import feign.RetryableException;

public class ClienteNotFoundException extends RetryableException{
	
	private static final long serialVersionUID = 1L;
	
	public ClienteNotFoundException(int status, String obj, HttpMethod httpMethod, Date retryAfter) {
		super(status, obj + " nao encontrado", httpMethod, retryAfter);
	}
}
