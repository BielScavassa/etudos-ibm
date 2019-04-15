package com.ibm.safebox.gateway.http.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateNewUserRequest {

	@JsonProperty("NAME")
	private String name;
	@JsonProperty("LASTNAME")
	private String lastName;
	@JsonProperty("USERNAME")
	private String username;
	@JsonProperty("PASSWORD")
	private String password;
	
	public CreateNewUserRequest() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
