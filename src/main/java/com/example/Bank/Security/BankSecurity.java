package com.example.Bank.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BankSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return daoAuthenticationProvider;
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception
//	{
//		auth.userDetailsService(userDetailsService);
//	}
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception
//	{
//		web.ignoring().antMatchers("/newuser");
//	}
//	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
//        http.authorizeRequests()
//                .antMatchers("/update*").hasRole("USER")
//                .antMatchers("/applyloan").hasRole("USER")
//                .antMatchers("/usersgt5L").hasRole("ADMIN")
//                .antMatchers("/users").hasAnyRole("USER","ADMIN")
//                .antMatchers("/newuser").permitAll()
//                .and().formLogin();
    }
}
