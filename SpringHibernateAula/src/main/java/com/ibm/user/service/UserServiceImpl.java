package com.ibm.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.user.model.UserModel;
import com.ibm.user.reposotory.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<UserModel> findByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public List<UserModel> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UserModel save(UserModel users) {
		return userRepository.save(users);
	}
}
