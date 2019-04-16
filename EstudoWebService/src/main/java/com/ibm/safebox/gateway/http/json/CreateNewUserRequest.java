package com.ibm.safebox.gateway.http.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateNewUserRequest {

	@JsonProperty("name")
	private String name;
	@JsonProperty("lastname")
	private String lastName;
	@JsonProperty("username")
	private String username;
	@JsonProperty("password")
	private String password;
    @JsonProperty("cellphone")
    private String cellphone;
    @JsonProperty("birthdate")
    private String birthdate;
	
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

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
}
