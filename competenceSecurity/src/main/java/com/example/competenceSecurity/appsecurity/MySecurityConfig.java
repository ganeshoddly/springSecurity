package com.example.competenceSecurity.appsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.competenceSecurity.appservice.MyUserDetailsService;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final MyUserDetailsService myUserDetailsService;
	
	@Autowired
	public MySecurityConfig(MyUserDetailsService myUserDetailsService) {
		super();
		this.myUserDetailsService = myUserDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.cors().and().csrf().disable().authorizeRequests()
			.antMatchers(HttpMethod.POST, "/sign-up").permitAll()
				.antMatchers("/*/floor1/**").hasRole("USER")
				.antMatchers("/*/floor1/**").hasRole("ADMIN")
				.and()
				.httpBasic();
	}
}
