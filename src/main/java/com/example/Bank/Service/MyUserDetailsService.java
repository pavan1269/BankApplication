package com.example.Bank.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Bank.Entity.User;
import com.example.Bank.Repo.UserRepo;





@Service
public class MyUserDetailsService implements UserDetailsService{

	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOptional=userRepo.findByUsername(username);
		System.out.println(userOptional.get().getName());
		
		userOptional.orElseThrow(()->new UsernameNotFoundException("User not found"+username));
		
		return new MyUserDetails(userOptional.get());
	}

}
