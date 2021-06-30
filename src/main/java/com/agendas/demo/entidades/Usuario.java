package com.agendas.demo.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "CEDULA", unique = true, nullable = false)
	private Long cedula;
	
	@Column(name = "CORREO")
	private String correo;
	
	@ManyToOne 
	@JoinColumn(name = "ID_UBICACION")
	@JsonBackReference
	private Ubicacion ubicacion;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_CONTRATO")
	@JsonBackReference
	private TipoContrato tipoContrato;
	
	@OneToMany(mappedBy = "usuario")
	@JsonManagedReference
	private List<CitaMedica> citasmedicas;
	
	
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

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public List<CitaMedica> getCitasmedicas() {
		return citasmedicas;
	}

	public void setCitasmedicas(List<CitaMedica> citasmedicas) {
		this.citasmedicas = citasmedicas;
	}

	
}
