package com.trabalho.casadeshow.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.trabalho.casadeshow.model.Cadastrologin;
import com.trabalho.casadeshow.model.CadastrologinPrincipal;
import com.trabalho.casadeshow.repository.UsuarioRepository;

@Service
public class ImplementsUserDetailsService implements UserDetailsService{

	@Autowired
    private UsuarioRepository ur;
	
	  @Override 
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		  Cadastrologin usuario = ur.findByUsername(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
     	return new CadastrologinPrincipal(usuario);
	}


}
