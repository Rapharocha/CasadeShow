package com.trabalho.casadeshow.repository;

import org.springframework.data.repository.CrudRepository;

import com.trabalho.casadeshow.model.Cadastrologin;


public interface UsuarioRepository extends CrudRepository<Cadastrologin,String> {

	Cadastrologin findByLogin(String login);
}
