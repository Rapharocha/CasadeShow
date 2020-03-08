package com.trabalho.casadeshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trabalho.casadeshow.model.Vendas;

public interface VendasRepository extends JpaRepository<Vendas,Long>{

	@Query("select v from Vendas v where usuario_username = :username and evento_codigo = :codigo")
	//select v from vendas v where usuario_username = ?1 and evento_codigo = ?2
	Vendas findByUsuarioAndEventos(@Param("username") String username,@Param("codigo") Long codigo);
	
	@Query("select v from Vendas v where usuario_username = :username")
	List<Vendas> findByUsername(@Param("username") String username);

	@Query("select v from Vendas v where ingressosComprados = :ingressosComprados")
	Vendas findByIngressosComprados(@Param("ingressosComprados")Integer ingressosComprados);
	
}
