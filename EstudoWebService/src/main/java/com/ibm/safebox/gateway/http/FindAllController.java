package com.ibm.safebox.gateway.http;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.safebox.domain.ClientDomain;
import com.ibm.safebox.gateway.http.json.UserRequestsAndResponses;
import com.ibm.safebox.gateway.http.mapper.ClientMapper;
import com.ibm.safebox.usecase.FindAll;

@RestController
@RequestMapping("/findall")
public class FindAllController {

	private final Logger log = LoggerFactory.getLogger(FindAllController.class);
	private final FindAll findAll;
	private ClientMapper clientMapper;

	@Autowired
	public FindAllController(FindAll findAll, ClientMapper clientMapper) {
		this.findAll = findAll;
		this.clientMapper = clientMapper;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserRequestsAndResponses>>  findAll() {
		List<ClientDomain> clientList = findAll.execute();
		List<UserRequestsAndResponses> responseList = new ArrayList<UserRequestsAndResponses>();
		
		for(ClientDomain client : clientList) {
			responseList.add(clientMapper.mapToReponse(client));
			log.info("Find user - {}",client.getName());
		}

		return ResponseEntity.ok().body(responseList);
	}
	
}
