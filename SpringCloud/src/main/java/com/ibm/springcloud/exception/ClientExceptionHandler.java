package com.ibm.springcloud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ClientExceptionHandler {

	@ResponseBody
	@ExceptionHandler(value = ClientBadRequestException.class)
	public ResponseEntity<?> exceptionHandler(ClientBadRequestException exception){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}
}
