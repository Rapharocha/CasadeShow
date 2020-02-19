

package com.trabalho.casadeshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.trabalho.casadeshow.model.Cadastrologin;


public interface UsuarioRepository extends JpaRepository<Cadastrologin,Long> {

	Cadastrologin findByUsername(String username);
}