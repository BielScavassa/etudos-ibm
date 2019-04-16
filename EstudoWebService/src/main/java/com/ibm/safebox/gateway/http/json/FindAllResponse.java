package com.ibm.safebox.gateway.http.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindAllResponse {

	@JsonProperty("id")
	private long id;
	@JsonProperty("name")
	private String name;
	
	public FindAllResponse(long id, String name) {
		this.id = id;
		this.name = name;
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
}
