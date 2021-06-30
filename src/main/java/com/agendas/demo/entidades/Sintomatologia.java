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
@Table(name= "SINTOMATOLOGIAS")
public class Sintomatologia {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "DETALLE", nullable = false)
	private String detalle;
	
	@Column(name = "PRIORIDAD")
	private Long prioridad;

	@OneToMany(mappedBy = "sintomatologia")
	@JsonManagedReference
	private List<CitaMedica> citasMedicas;
	
	//GETTERS AND SETTERS	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Long getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Long prioridad) {
		this.prioridad = prioridad;
	}

	public List<CitaMedica> getCitasMedicas() {
		return citasMedicas;
	}

	public void setCitasMedicas(List<CitaMedica> citasMedicas) {
		this.citasMedicas = citasMedicas;
	}
	
	
}
