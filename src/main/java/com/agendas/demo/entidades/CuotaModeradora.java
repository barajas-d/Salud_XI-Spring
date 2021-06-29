package com.agendas.demo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CUOTAS_MODERADORAS")
public class CuotaModeradora {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "VALOR")
	private Float valor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TIPO_CITA")
	@JsonBackReference
	private TipoCita tiposCita;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TIPO_CONTRATO")
	@JsonBackReference
	private TipoContrato tiposContrato;

	
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

	public TipoCita getTiposCita() {
		return tiposCita;
	}

	public void setTiposCita(TipoCita tiposCita) {
		this.tiposCita = tiposCita;
	}

	public TipoContrato getTiposContrato() {
		return tiposContrato;
	}

	public void setTiposContrato(TipoContrato tiposContrato) {
		this.tiposContrato = tiposContrato;
	}
	
	
	
	
}
