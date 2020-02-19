package com.trabalho.casadeshow.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{



	@Id
	private String nomeRole;
	
	@ManyToMany
	private List<Cadastrologin>usuarios;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.getNomeRole();
	}

	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}

	private List<Cadastrologin> getUsuarios() {
		return usuarios;
	}

	private void setUsuarios(List<Cadastrologin> usuarios) {
		this.usuarios = usuarios;
	}

}
