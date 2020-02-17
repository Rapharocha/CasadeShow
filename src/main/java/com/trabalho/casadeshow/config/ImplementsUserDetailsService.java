package com.trabalho.casadeshow.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.trabalho.casadeshow.model.Cadastrologin;
import com.trabalho.casadeshow.repository.UsuarioRepository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService{

	@Autowired
    private UsuarioRepository ur;
	
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		Cadastrologin usuario = ur.findByLogin(login);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		return usuario;
	}


}
