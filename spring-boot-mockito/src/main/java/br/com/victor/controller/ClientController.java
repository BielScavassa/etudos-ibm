package br.com.victor.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.victor.model.Client;
import br.com.victor.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("client")
@Api(value = "client", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@ApiOperation(value = "lista todos os clientes cadastrados")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listagem efetuada com sucesso"),
			@ApiResponse(code = 408, message = "Request timeout"),
			@ApiResponse(code = 422, message = "Validation error"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	@RequestMapping(method = RequestMethod.GET)
	public List<Client> listAll(){
		log.info("List user");
		return clientService.listAll();
	}
	@ApiOperation(value = "cadastra ou atualiza(se tiver id) cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cadastro ou Atualizacao efetuada com sucesso"),
			@ApiResponse(code = 408, message = "Request timeout"),
			@ApiResponse(code = 422, message = "Validation error"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Client> saveOrUpdate(@RequestBody Client client) {
		log.info("create a new user - {}",client.getName());
		Client savedClient = clientService.saveOrUpdate(client);
		return  ResponseEntity.ok().body(savedClient);
	}

}
