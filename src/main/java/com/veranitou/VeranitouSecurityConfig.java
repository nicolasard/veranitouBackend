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
public class VeranitouSecurityConfig
   extends WebSecurityConfigurerAdapter {

   	final static Logger logger = Logger.getLogger(VeranitouSecurityConfig.class);

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) {
  	try{
		logger.info("Configurin the authentication method");

  		auth.inMemoryAuthentication().withUser("user").password("123").roles("USER");
  	}
	catch (Exception ex){
		logger.error("Excepcion loading VeranitouSecurityConfig",ex);
	}
  }

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		logger.info("Configurin the secured pages matchers");

		//Here i config how to secure access to certain pages
	    http.authorizeRequests()
		.antMatchers("/secure/**").access("hasRole('ROLE_USER')")
		.and()
		    .formLogin().loginPage("/login").failureUrl("/login?error")
		    .usernameParameter("username").passwordParameter("password")
		.and()
		    .logout().logoutSuccessUrl("/login?logout")
		.and()
		    .csrf();
	}
}