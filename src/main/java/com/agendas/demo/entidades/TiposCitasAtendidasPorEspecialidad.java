package com.agendas.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TIPOS_CITAS_ATENDIDAS_POR_ESPECIALIDAD")
public class TiposCitasAtendidasPorEspecialidad {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_ESPECIALIDAD")
	@JsonBackReference
	private Especialidad especialidad;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_CITA")
	@JsonBackReference
	private TipoCita tipoCita;

	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public TipoCita getTipoCita() {
		return tipoCita;
	}

	public void setTipoCita(TipoCita tipoCita) {
		this.tipoCita = tipoCita;
	}
	
	
}
