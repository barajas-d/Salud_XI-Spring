package com.agendas.demo.entidadesDTO;

public class CentroMedicoPorUbicacionDTO {
	
	private Long id;
	private Long centroMedico;
	private Long ubicacion;
	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCentroMedico() {
		return centroMedico;
	}
	public void setCentroMedico(Long centroMedico) {
		this.centroMedico = centroMedico;
	}
	public Long getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Long ubicacion) {
		this.ubicacion = ubicacion;
	}
	
}
