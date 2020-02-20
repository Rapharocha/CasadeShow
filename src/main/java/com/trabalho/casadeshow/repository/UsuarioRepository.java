

package com.trabalho.casadeshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.casadeshow.model.Cadastrologin;


public interface UsuarioRepository extends JpaRepository<Cadastrologin,String> {

	Cadastrologin findByUsername(String username);
}