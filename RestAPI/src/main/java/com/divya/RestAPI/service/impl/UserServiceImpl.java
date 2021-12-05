package com.divya.RestAPI.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.divya.RestAPI.model.User;
import com.divya.RestAPI.repository.*;
import com.divya.RestAPI.Exception.*;
import com.divya.RestAPI.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		
		return (List<User>) userRepository.findAll();
	}	

	@Override
	public User getUserById(Integer id) {
		
		return userRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("User","Id",id));
	}

	@Override
	public User UpdateUser(User us, Integer id) {
		//check if user with given id is present
		User existinguser = userRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("User","Id",id));
		existinguser.setId(us.getId());
		existinguser.setName(us.getName());
		existinguser.setEmail(us.getEmail());
		
		userRepository.save(existinguser);
		return existinguser;
	}



}
