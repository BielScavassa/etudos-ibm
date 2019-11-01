package com.ibm.specification.example;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchCriteriaExample {

	private String key;
	private String operation;
	private Object value;
	private Boolean orPredicate;

	@Autowired
	public SearchCriteriaExample(String key, String operation, Object value) {
		this.key = key;
		this.operation = operation;
		this.value = value;
	}
	
	@Autowired
	public SearchCriteriaExample(String key, String operation, Object value, Boolean orPredicate) {
		this.key = key;
		this.operation = operation;
		this.value = value;
		this.orPredicate = orPredicate;
	}
	
	public Boolean isOrPredicate() {
		return this.orPredicate;
	}
	

}
