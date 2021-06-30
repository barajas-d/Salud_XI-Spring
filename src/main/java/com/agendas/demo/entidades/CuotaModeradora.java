package com.agendas.demo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "CUOTAS_MODERADORAS")
public class CuotaModeradora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "VALOR")
	private Float valor;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_CITA")
	@JsonBackReference
	private TipoCita tipoCita;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_CONTRATO")
	@JsonBackReference
	private TipoContrato tiposContrato;
	
	
	//CONSTRUCTORES
	public CuotaModeradora() {
		super();
	}
	
	public CuotaModeradora(Float valor, TipoCita tipoCita, TipoContrato tiposContrato) {
		super();
		this.valor = valor;
		this.tipoCita = tipoCita;
		this.tiposContrato = tiposContrato;
	}
	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public TipoCita getTipoCita() {
		return tipoCita;
	}

	public void setTipoCita(TipoCita tipoCita) {
		this.tipoCita = tipoCita;
	}

	public TipoContrato getTiposContrato() {
		return tiposContrato;
	}

	public void setTiposContrato(TipoContrato tiposContrato) {
		this.tiposContrato = tiposContrato;
	}
	
	
	
	
}
