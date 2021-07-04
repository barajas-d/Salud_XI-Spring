package com.agendas.demo.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ESPECIALIDADES")
public class Especialidad {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;

	@OneToMany(mappedBy = "especialidad")
	//@JsonManagedReference
	@JsonIgnore
	private List<Medico> medicos;
	
	@OneToMany(mappedBy = "especialidad")
	//@JsonManagedReference
	@JsonIgnore
	private List<TiposCitasAtendidasPorEspecialidad> tiposCitasAtendidasPorEspecialidades;
	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<TiposCitasAtendidasPorEspecialidad> getTiposCitasAtendidasPorEspecialidades() {
		return tiposCitasAtendidasPorEspecialidades;
	}

	public void setTiposCitasAtendidasPorEspecialidades(
			List<TiposCitasAtendidasPorEspecialidad> tiposCitasAtendidasPorEspecialidades) {
		this.tiposCitasAtendidasPorEspecialidades = tiposCitasAtendidasPorEspecialidades;
	}
	
	
	
}
