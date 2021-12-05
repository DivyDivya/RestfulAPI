package com.divya.RestAPI.service;

import java.util.List;
import java.util.Optional;

import com.divya.RestAPI.model.User;

public interface UserService {

	User saveUser(User user);
	List<User> getAllUsers();
	User getUserById(Integer id);
	User UpdateUser(User us, Integer id);
}
