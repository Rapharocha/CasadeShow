package com.trabalho.casadeshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.casadeshow.model.Role;

public interface RoleRepository extends JpaRepository <Role,String> {

	Role findByNomeRole(String string);

}
