package com.ibm.safebox.gateway.http;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ibm.safebox.config.exception.FeatureException;
import com.ibm.safebox.config.exception.ValidationException;
import com.ibm.safebox.domain.error.ErroField;
import com.ibm.safebox.gateway.http.json.errorhandling.ErrorResponse;

@ControllerAdvice
public class CustumerExceptionHandler {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<ErrorResponse> processFeatureException(IllegalArgumentException e){
			log.warn("Ocurred integration error: {}",e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ErrorResponse.ERR_BAD_REQUEST,e.getMessage()));
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResponseEntity<ErrorResponse> processException(Exception e){
		log.error("An unexpected error ocurred:{}",e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ErrorResponse(ErrorResponse.ERR_INTERNAL_SERVER_ERROR, e.getMessage()));
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ResponseBody
	public ResponseEntity<ErrorResponse> processMethodNotSupportedException(Exception e){
		log.warn("Method not supported ocurred :{}",e.getMessage(),e);
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
				.body(new ErrorResponse(ErrorResponse.ERR_METHOD_NOT_SUPPORTED, e.getMessage()));
	}

	@ExceptionHandler(FeatureException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<ErrorResponse> processFeatureException(FeatureException e){
		log.warn("Feature error ocurred:{}",e.getMessage(),e);
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ErrorResponse(ErrorResponse.ERR_NOT_FOUND, e.getMessage()));
	}

	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ResponseBody
	public ResponseEntity<ErrorResponse> processValidationException(ValidationException e){
		log.warn("validation error ocurred:{}",e.getMessage(),e);
		final List<ErroField> fieldErrors = e.getErrorFields();
		final ErrorResponse errorResponse = new ErrorResponse(ErrorResponse.ERR_VALIDATION);

		Map<String,List<String>> fieldMaps = new HashMap<>();

		fieldErrors.forEach(erroField ->
				fieldMaps.computeIfAbsent(erroField.getMenssage(),
						fields -> new ArrayList<>()).add(erroField.getMenssage()));
		List<ErroField> errors = new ArrayList<>();

		fieldMaps.forEach((message,field)->{
			errors.add(new ErroField(message,field));
		});
		errorResponse.setErrorField(fieldErrors);

		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
				.body(errorResponse);
	}
}
