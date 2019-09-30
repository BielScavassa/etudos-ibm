package com.ibm.springcloud.exception;

import org.springframework.stereotype.Component;

import feign.Request.HttpMethod;
import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class ClientFeignErrorDecoder implements ErrorDecoder {

	private ErrorDecoder defaultErrorDecoder = new Default();

	@Override
	public Exception decode(String methodKey, Response response) {
		if (response.status() >= 400 && response.status() <= 499) {
			throw new ClienteNotFoundException(response.status(), "Endereco",
					HttpMethod.valueOf(response.request().method()), null);
		}
		return defaultErrorDecoder.decode(methodKey, response);
	}

}
