package com.agendas.demo.entidadesDTO;

public class MedicoDTO {
	
	private Long id;
	private String nombre;
	private Long cedula;
	private Long intensidadHoraria;
	private Long centroMedico;
	private Long especialidad;
	
	//GETTEERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nimbre) {
		this.nombre = nimbre;
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
	public Long getCentroMedico() {
		return centroMedico;
	}
	public void setCentroMedico(Long centroMedico) {
		this.centroMedico = centroMedico;
	}
	public Long getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Long especialidad) {
		this.especialidad = especialidad;
	}
	
}
