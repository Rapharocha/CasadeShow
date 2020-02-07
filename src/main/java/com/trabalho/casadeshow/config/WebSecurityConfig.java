//package com.trabalho.casadeshow.config;
//
//
//
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//
//
//
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		
//		 //PERMISSÕES DA URL 
//		 //quero configurar como será a segurança para as aquisições
//		  .authorizeRequests() 		  
//		  .antMatchers("/css/**")
//		  .permitAll()
//		  .antMatchers("/img/**")
//		  .permitAll()
//		  //para entrar na página home, precisará da permissão "PG_HOME"
//         .antMatchers("/").hasAnyRole("PG_HOME")
//           .antMatchers("/eventos").hasAnyRole("PG_EVENTOS")
//           .antMatchers("/historico").hasAnyRole("PG_HISTORICO")
//           .antMatchers("/casasdeshow").hasAnyRole("PG_CASASDESHOW")
//		  //Atalho para que diga que o usuario precisa estar autenticado
//		  //para qualquer aquisição.
//		    .anyRequest()
//		     .authenticated()
//		  //--------------------------------------------------------  
//		   .and()
//		  //INFORMAR QUE QUER ISSO POR MEIO DE UM FORMULÁRIO DE LOGIN
//		     .formLogin()
//		        .loginPage("/login")
//		        .permitAll()
//		     .and()
//		     //Para informar que quer um botão para sair da aplicação
//		        .logout()
//		                //para voltar para nossa pagina de login, porem por ser uma url diferente precisa permitir
//		             .logoutSuccessUrl("/login?logout")
//		             .permitAll();	 
//		
//	}
//	
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Bean
//	public AuthenticationProvider authProvider() 
//	{
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//		return provider;
// }
//	
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		
//		auth.inMemoryAuthentication()
//		   .withUser("Vinicius").password("{noop}web").roles("PG_HOME","PG_EVENTOS","PG_CASASDESHOW")
//		.and()
//		    .withUser("Raphael").password("{noop}senhadoraphinha").roles("PG_CASASDESHOW","PG_HOME");
//	}
//	
//	
	
//
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		
//		List<UserDetails> users = new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("Raphael").password("1234").roles("USER").build());
//	    
//		return new InMemoryUserDetailsManager(users);
//}
//}
