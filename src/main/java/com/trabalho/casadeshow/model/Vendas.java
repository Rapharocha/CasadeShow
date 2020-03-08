package com.trabalho.casadeshow.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vendas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer ingressosComprados;
	
	private Double valorTotal;
	
	@OneToOne
	private Cadastroevento evento;
	
	@ManyToOne
	private Cadastrologin usuario;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getIngressosComprados() {
		return ingressosComprados;
	}
	public void setIngressosComprados(int ingressosComprados) {
		this.ingressosComprados = ingressosComprados;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Cadastroevento getEvento() {
		return evento;
	}
	public void setEvento(Cadastroevento evento) {
		this.evento = evento;
	}
	public Cadastrologin getUsuario() {
		return usuario;
	}
	public void setUsuario(Cadastrologin usuario) {
		this.usuario = usuario;
	}
	
}
