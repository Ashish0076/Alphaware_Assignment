package com.alphaware.blogapplication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alphaware.blogapplication.Exceptions.ResourceNotFoundException;
import com.alphaware.blogapplication.Model.User;
import com.alphaware.blogapplication.Model.UserRole;
import com.alphaware.blogapplication.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
	@Autowired
	private PasswordEncoder pc ;

    @Override
    public User register(User user) {
        // Implement user registration logic here
    	user.setRole(UserRole.USER);
    	user.setPassword(pc.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) throws ResourceNotFoundException {
    	User u = userRepository.findByUsername(username);
    	
    	if(u==null) {
    		throw new ResourceNotFoundException("User not found with username: " + username);
    	}
    	
    	return u;
    }

	@Override
	public User findByname(String name) throws ResourceNotFoundException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication() ;
		
		System.out.println(authentication.getDetails());
    	User u = userRepository.findByName(name);
    	
    	if(u==null) {
    		throw new ResourceNotFoundException("User not found with username: " + name);
    	}
    	
    	u.setUsername("");
    	
    	return u;
	}

	@Override
	public List<User> getAllUsers() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if(userRepository.findAll()==null) {
			throw new ResourceNotFoundException("User not found ");
		}else {
			return userRepository.findAll();
		}

	}

}

