package com.ibm.safebox.gateway.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.safebox.domain.ClientDomain;
import com.ibm.safebox.gateway.http.json.CreateNewUserRequest;
import com.ibm.safebox.gateway.http.json.CreateNewUserResponse;
import com.ibm.safebox.gateway.http.mapper.ClientMapper;
import com.ibm.safebox.gateway.usecase.RegisterNewUser;

@RestController
@RequestMapping("/newuser")
public class CreateNewUserController {

	private final Logger log = LoggerFactory.getLogger(CreateNewUserController.class);
	private final RegisterNewUser registerNewUser;
	private final ClientMapper clientMapper;

	@Autowired
	public CreateNewUserController(RegisterNewUser registerNewUser, ClientMapper clientMapper) {
		this.registerNewUser = registerNewUser;
		this.clientMapper = clientMapper;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CreateNewUserResponse> save(@RequestBody CreateNewUserRequest client)  {
		ClientDomain savedClient = registerNewUser.execute(clientMapper.mapToDomain(client));
		CreateNewUserResponse response = clientMapper.mapToReponse(savedClient);

		log.info("create a new user - {}",client.getName());
		
		return ResponseEntity.ok().body(response);
	}
}