package com.ibm.exception;

public class ObrigatorioException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObrigatorioException(String obj) {
		super(obj + " é obrigatório");
	}

}
