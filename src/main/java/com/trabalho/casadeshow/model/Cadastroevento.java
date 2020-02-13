package com.trabalho.casadeshow.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Cadastroevento {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String nomeevento;	
	private int capacidade;
	
	@ManyToOne
	@JoinColumn(name = "cadastrocasa_codigo", nullable=false)
    private Cadastrocasa cadastrocasa;
	
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataevento;
	
	@NumberFormat(pattern = "#,###.00")
	private BigDecimal valor;
	
	
	//(Métodos Getters e Setters)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getNomeevento() {
		return nomeevento;
	}
	public void setNomeevento(String nomeevento) {
		this.nomeevento = nomeevento;
	}

	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public Date getDataevento() {
		return dataevento;
	}
	public void setDataevento(Date dataevento) {
		this.dataevento = dataevento;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Cadastrocasa getCadastrocasa() {
		return cadastrocasa;
	}
	public void setCadastrocasa(Cadastrocasa cadastrocasa) {
		this.cadastrocasa = cadastrocasa;
	}
	
	
	
}
