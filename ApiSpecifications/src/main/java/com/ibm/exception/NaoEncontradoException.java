package com.ibm.exception;

public class NaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NaoEncontradoException(String obj) {
		super(obj + " nao encontrado");
	}

}
