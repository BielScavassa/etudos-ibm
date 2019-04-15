package com.ibm.web.serivce;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean validateuser(String userId, String password) {
		return userId.equalsIgnoreCase("teste") && password.equals("123aD");
	}
}
