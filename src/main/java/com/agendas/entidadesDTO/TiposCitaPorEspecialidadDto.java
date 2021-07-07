package com.agendas.entidadesDTO;

public class TiposCitaPorEspecialidadDto {

	private Long id;
	private Long especialidad;
	private Long tipoCita;
	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Long especialidad) {
		this.especialidad = especialidad;
	}
	public Long getTipoCita() {
		return tipoCita;
	}
	public void setTipoCita(Long tipoCita) {
		this.tipoCita = tipoCita;
	}
	
}
