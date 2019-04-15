package com.ibm.safebox.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ClientDomain {

	private long id;
	
	@NotEmpty(message = "Name cannot be null.")
	@Size(min = 3, max = 80, message = "Name Me must be between 3 and 80 characters")
	private String name;
	
	@NotEmpty(message = "Lastname cannot be null.")
	@Size(min = 3, max = 80, message = "LastName Me must be between 3 and 80 characters")
	private String lastName;
	
	@NotEmpty(message = "Username cannot be null.")
	@Size(min = 3, max = 80, message = "Username Me must be between 3 and 80 characters")
	private String username;
	
	@NotEmpty(message = "Password cannot be null.")
	private String password;
	
	private String publicKey;
	
	@Size(min = 14, max = 15, message = "Cellphone Me must be between 14 and 15 characters")
	private String cellphone;
	
	private String birthdate;

	public ClientDomain() {
		super();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
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
