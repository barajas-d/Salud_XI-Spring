package com.agendas.entidadesDTO;

public class TipoCitaDTO {

	private Long id;
	
	private String nombre;
	
	private Long duracion;

	
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

	public Long getDuracion() {
		return duracion;
	}

	public void setDuracion(Long duracion) {
		this.duracion = duracion;
	}
}
