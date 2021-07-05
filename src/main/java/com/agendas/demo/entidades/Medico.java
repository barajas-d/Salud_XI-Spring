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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "MEDICOS")
public class Medico {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "CEDULA", unique = true)
	private Long cedula;
	
	@Column(name = "INTENSIDAD_HORARIA", nullable = false)
	private Long intensidadHoraria;
	
	@ManyToOne
	@JoinColumn(name = "ID_CENTRO_MEDICO")
	//@JsonBackReference
	private CentroMedico centroMedico;
	
	@ManyToOne
	@JoinColumn(name = "ID_ESPECIALIDAD")
	private Especialidad especialidad;
	
	@OneToMany(mappedBy = "medico")
	//@JsonManagedReference
	@JsonIgnore
	private List<CitaMedica> citasMedicas;

	//CONSTRUCTORES
	public Medico() {
		super();
	}
	
	public Medico(String nombre2, Long cedula2, Long intensidadHoraria2, CentroMedico centroMedico2,
			Especialidad especialidad2) {
		this.nombre = nombre2;
		this.cedula = cedula2;
		this.intensidadHoraria = intensidadHoraria2;
		this.centroMedico = centroMedico2;
		this.especialidad = especialidad2;
	}
	
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

	public Long getIntensidadHoraria() {
		return intensidadHoraria;
	}

	public void setIntensidadHoraria(Long intensidadHoraria) {
		this.intensidadHoraria = intensidadHoraria;
	}

	public CentroMedico getCentroMedico() {
		return centroMedico;
	}

	public void setCentroMedico(CentroMedico centroMedico) {
		this.centroMedico = centroMedico;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public List<CitaMedica> getCitasMedicas() {
		return citasMedicas;
	}

	public void setCitasMedicas(List<CitaMedica> citasMedicas) {
		this.citasMedicas = citasMedicas;
	}

	
}
