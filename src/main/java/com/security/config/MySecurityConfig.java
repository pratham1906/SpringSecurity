package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	PasswordEncoder passwordEncoder =
		    PasswordEncoderFactories.createDelegatingPasswordEncoder();
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
	.authorizeRequests()
	 .antMatchers("/signin","/register").permitAll().anyRequest()
	.authenticated()
	.and().
	formLogin()
	.loginPage("/signin")
	.loginProcessingUrl("/dologin")
	.defaultSuccessUrl("/register/");
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication().withUser("john").password(passwordEncoder.encode("abc")).roles("NORMAL");
	auth.inMemoryAuthentication().withUser("Micheal").password(passwordEncoder.encode("xyz")).roles("ADMIN");
	}

	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder(10);
//	}
}
