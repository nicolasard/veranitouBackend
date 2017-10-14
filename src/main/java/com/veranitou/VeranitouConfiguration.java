package com.veranitou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.apache.log4j.Logger;

@Configuration
@EnableWebSecurity
public class VeranitouConfiguration
   extends WebSecurityConfigurerAdapter {

   	final static Logger logger = Logger.getLogger(VeranitouConfiguration.class);

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) {
  	try{
  		auth.inMemoryAuthentication().withUser("user").password("123").roles("USER");
  	}
	catch (Exception ex){
		logger.error("Excepcion loading VeranitouConfiguration",ex);
	}
  }

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		logger.info("Configuring auth form");
	    http.authorizeRequests()
		.antMatchers("/hola/**").access("hasRole('ROLE_USER')")
		.and()
		    .formLogin().loginPage("/login").failureUrl("/login?error")
		    .usernameParameter("username").passwordParameter("password")
		.and()
		    .logout().logoutSuccessUrl("/login?logout")
		.and()
		    .csrf();
	}
}