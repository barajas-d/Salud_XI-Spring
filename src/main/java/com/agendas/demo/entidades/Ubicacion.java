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
@Table(name = "UBICACIONES")
public class Ubicacion {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "BARRIO", nullable = false)
	private String barrio;
	
	@OneToMany(mappedBy = "ubicacion")
	//@JsonManagedReference
	@JsonIgnore
	private List<Usuario> usuarios;

	@OneToMany(mappedBy = "ubicacion")
	//@JsonManagedReference
	@JsonIgnore
	private List<CentroMedicoPorUbicacion> centrosMedicos;
	
	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<CentroMedicoPorUbicacion> getCentrosMedicos() {
		return centrosMedicos;
	}

	public void setCentrosMedicos(List<CentroMedicoPorUbicacion> centrosMedicos) {
		this.centrosMedicos = centrosMedicos;
	}
	
}
