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
@Table(name = "TIPOS_CONTRATOS")
public class TipoContrato {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "PRIORIDAD", nullable = false)
	private Long prioridad;
	
	@OneToMany(mappedBy = "tiposContrato")
	@JsonManagedReference
	private List<CuotaModeradora> cuotasModeradora;
	
	@OneToMany(mappedBy = "tipoContrato")
	@JsonManagedReference
	private List<Usuario> usuarios;
	
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

	public Long getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Long prioridad) {
		this.prioridad = prioridad;
	}

	public List<CuotaModeradora> getCuotasModeradora() {
		return cuotasModeradora;
	}

	public void setCuotasModeradora(List<CuotaModeradora> cuotasModeradora) {
		this.cuotasModeradora = cuotasModeradora;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}
