package com.agendas.demo.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CENTROS_MEDICOS")
public class CentroMedico {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;

	@OneToMany(mappedBy = "centroMedico")
	@JsonManagedReference
	private List<CentroMedicoPorUbicacion> ubicaciones;
	
	@OneToMany(mappedBy = "centroMedico")
	@JsonManagedReference
	private List<Medico> medicos;
	
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

	public List<CentroMedicoPorUbicacion> getUbicaciones() {
		return ubicaciones;
	}

	public void setUbicaciones(List<CentroMedicoPorUbicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}
	
	
}
