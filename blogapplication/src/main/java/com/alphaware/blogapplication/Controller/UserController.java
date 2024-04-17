package com.alphaware.blogapplication.Controller;

import com.alphaware.blogapplication.Exceptions.ResourceNotFoundException;
import com.alphaware.blogapplication.Model.User;
import com.alphaware.blogapplication.Service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.register(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name) throws ResourceNotFoundException {
        User user = userService.findByname(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
	@GetMapping("/logIn")
	public ResponseEntity<User> logInUserHandler(Authentication auth) throws ResourceNotFoundException{
		 Optional<User> opt= Optional.of(userService.findByUsername(auth.getName()));
		 if(opt.isEmpty()) throw new ResourceNotFoundException("No user found") ;
		 User user = opt.get();
		 return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
	}
	
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() throws ResourceNotFoundException {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
	
	
//	@PostMapping("/logini")
//	public ResponseEntity<User> logInUserHandler(@RequestBody String token) throws ResourceNotFoundException{
//		 String username = JwtToken.decodeJwt(token);
//		 Optional<User> opt= cRepo.findByUsername(username);
//		 if(opt.isEmpty()) throw new UserException("No user found") ;
//		 return new ResponseEntity<>(opt.get(), HttpStatus.ACCEPTED);
//	}
    
}

