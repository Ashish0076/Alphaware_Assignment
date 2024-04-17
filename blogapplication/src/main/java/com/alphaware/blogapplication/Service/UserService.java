package com.alphaware.blogapplication.Service;

import java.util.List;

import com.alphaware.blogapplication.Exceptions.ResourceNotFoundException;
import com.alphaware.blogapplication.Model.User;

public interface UserService {

	User register(User user);

	User findByUsername(String username) throws ResourceNotFoundException;
	
	User findByname(String name) throws ResourceNotFoundException;

	List<User> getAllUsers() throws ResourceNotFoundException;

}
