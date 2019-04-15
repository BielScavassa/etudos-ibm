package com.ibm.safebox.gateway.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.safebox.gateway.http.json.CreateNewUserRequest;
import com.ibm.safebox.gateway.http.json.CreateNewUserResponse;

@RestController
@RequestMapping("/newuser")
public class CreateNewUserController {

	private final Logger log = LoggerFactory.getLogger(CreateNewUserController.class);
	

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CreateNewUserResponse> save(@RequestBody CreateNewUserRequest client)  {
		log.info("create a new user - {}",client.getName());
//		Client savedClient = registerNewUser.execute(mapper.mapToDomain(client));
//		CreateNewUserResponse response = (CreateNewUserResponse) mapper.mapToResponse(savedClient,CreateNewUserResponse.class);
//		return ResponseEntity.ok().body(response);
		return null;
	}
}