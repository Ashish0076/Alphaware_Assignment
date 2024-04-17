package com.alphaware.blogapplication.Configure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alphaware.blogapplication.Model.User;
import com.alphaware.blogapplication.Repository.UserRepository;



@Service
public class ManualUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private UserRepository uRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.of(uRepo.findByUsername(username));
        
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        User us = user.get();

        List<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority autho = new SimpleGrantedAuthority("ROLE_" + us.getRole());
        authorities.add(autho);

//        // Print all authorities
//        System.out.println("Authorities for user " + us.getUsername() + ":");
//        for (GrantedAuthority authority : authorities) {
//            System.out.println(authority.getAuthority());
//        }

        org.springframework.security.core.userdetails.User secUser = new org.springframework.security.core.userdetails.User(
                us.getUsername(),
                us.getPassword(),
                authorities
        );

        return secUser;
    }

}

