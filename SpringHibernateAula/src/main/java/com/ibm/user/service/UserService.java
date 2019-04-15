package com.ibm.user.service;

import java.util.List;

import com.ibm.user.model.UserModel;

public interface UserService {
	List<UserModel> findByName(String name);
	List<UserModel> findAll();
	UserModel save(UserModel user);
	
}
