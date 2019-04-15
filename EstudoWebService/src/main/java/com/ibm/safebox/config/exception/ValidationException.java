package com.ibm.safebox.config.exception;

import java.util.List;

public class ValidationException extends  RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private List<FieldError>  errorFields;

    public ValidationException(String message){
        super(message);
    }

    public ValidationException(String message,List<FieldError> erroFields){
        super(message);
        this.errorFields = erroFields;
    }


    public List<FieldError> getErrorFields() {
        return errorFields;
    }
}
