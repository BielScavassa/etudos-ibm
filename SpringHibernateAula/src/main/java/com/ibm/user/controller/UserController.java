package com.ibm.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.user.model.UserModel;
import com.ibm.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value ="/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserModel> save(@RequestBody UserModel users){
		UserModel savedUser = userService.save(users);
		return ResponseEntity.status(200).body(savedUser);
	}
	
	@GetMapping("/all")
	public List<UserModel> getAll(){
		return userService.findAll();
	}
	
	@GetMapping("/name")
	public List<UserModel> getUser(@RequestParam("name") String name){
		if(name != null)
			return userService.findByName(name);
		else
			throw new IllegalArgumentException("Nome não encontrado.");
	}
	
	@GetMapping("/id {id}")
	public UserModel getId(@PathVariable("id") Long id) {
		return null;
	}
	
	
}
