package com.example.Bank.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.Bank.Entity.User;


public class MyUserDetails implements UserDetails{

//    private String username;
//    private String password;
//    private List<GrantedAuthority> authorities;
    
	private User user;
    
	public MyUserDetails() {
		
	}
	
	
	public MyUserDetails(User user) {
//		this.username=user.getUsername();
//		this.password=user.getPassword();
//		this.authorities = Arrays.stream(user.getRole().split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
		this.user=user;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}



	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}



	
}
