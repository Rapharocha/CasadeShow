package com.trabalho.casadeshow.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.
		   csrf().disable().
		    authorizeRequests()
		    .antMatchers("/").hasAnyRole("PHome")
		    .antMatchers("/casasdeshow").hasAnyRole("PCasa")
		    .antMatchers("/eventos").hasAnyRole("PEvento")
		    .antMatchers("/historico").hasAnyRole("PHistorico")
		    .antMatchers("/cadastro").permitAll()
		    .anyRequest()
		    .authenticated()
		.and()
		    .formLogin()
		    .loginPage("/login")
		    .permitAll()
		.and()
		   .logout()
		   .logoutSuccessUrl("/login?logout")
		   .permitAll();	
	}
}
