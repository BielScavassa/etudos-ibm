package com.ibm.springcloud.exception;

import org.springframework.stereotype.Component;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class ClientFeignErrorDecoder implements ErrorDecoder {

	private ErrorDecoder defaultErrorDecoder =  new Default();
	
	@Override
	public Exception decode(String methodKey, Response response) {
		if (response.status() >= 500 && response.status() <= 599) {
			throw new ClientBadRequestException("Not Found Feign");
		}
		return defaultErrorDecoder.decode(methodKey, response);
	}

}
