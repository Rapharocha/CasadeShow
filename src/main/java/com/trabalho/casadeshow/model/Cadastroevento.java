package com.trabalho.casadeshow.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Cadastroevento {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message = "O campo 'Evento' não pode estar vazio")
	@Size(message = "O nome do evento não pode contar mais que 40 caracteres")
	private String nomeevento;
	
	@NotNull(message = "O campo capacidade não pode estar vazio")
	@DecimalMin(value = "1", message = "Capacidade minima é 1")
	@NumberFormat(pattern = "#.###")
	private int capacidade;
	private int ingresso;

	
	@ManyToOne
	@JoinColumn(name = "cadastrocasa_codigo", nullable=false)
	@NotNull(message = "Selecione uma Casa de Show")
    private Cadastrocasa cadastrocasa;
	
	@NotNull(message = "O campo 'Data' não pode estar vazio")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataevento;
	
	@NumberFormat(pattern = "#,###.00")
	@NotNull(message = "O campo 'valor' não pode estar vazio ")
	@DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0.01")
	@DecimalMax(value = "999999999999999", message = "Valor não pode ser maior que 999.999.999.999.999,00")
	private BigDecimal valor;
	
	@Enumerated(EnumType.STRING)
	private GeneroEvento genero;
	
	
	public GeneroEvento getGenero() {
		return genero;
	}
	public void setGenero(GeneroEvento genero) {
		this.genero = genero;
	}
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
	public int getIngresso() {
		return ingresso;
	}
	public void setIngresso(int ingresso) {
		this.ingresso = ingresso;
	}

}
