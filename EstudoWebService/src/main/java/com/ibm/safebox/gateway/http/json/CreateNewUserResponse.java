package com.ibm.safebox.gateway.http.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateNewUserResponse {

	@JsonProperty("ID")
	private long id;
	@JsonProperty("NAME")
	private String name;
	@JsonProperty("LASTNAME")
	private String lastName;
	@JsonProperty("USERNAME")
	private String username;
	
	public CreateNewUserResponse() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
}
