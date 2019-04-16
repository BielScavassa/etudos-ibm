package com.ibm.safebox.config.exception;

import com.ibm.safebox.domain.error.ErroField;

import java.util.List;


public class ValidationException extends  RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private List<ErroField>  errorFields;

    public ValidationException(String message){
        super(message);
    }

    public ValidationException(String message,List<ErroField> erroFields){
        super(message);
        this.errorFields = erroFields;
    }


    public List<ErroField> getErrorFields() {
        return errorFields;
    }
}
