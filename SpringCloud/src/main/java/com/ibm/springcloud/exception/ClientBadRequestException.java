package com.ibm.springcloud.exception;

public class ClientBadRequestException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ClientBadRequestException(String msg) {
		super(msg);
	}
}
