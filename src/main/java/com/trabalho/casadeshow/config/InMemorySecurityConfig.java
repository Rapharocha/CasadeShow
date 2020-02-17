package com.trabalho.casadeshow.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class InMemorySecurityConfig {

	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDetailsService);
		  // .inMemoryAuthentication()
		   //.withUser("ADM").password("{noop}1234").roles("PHome","PEvento","PHistorico","PCasa")
		   //.and()
		   //.withUser("User").password("{noop}1234").roles("PHome","PHistorico");
	}
}
