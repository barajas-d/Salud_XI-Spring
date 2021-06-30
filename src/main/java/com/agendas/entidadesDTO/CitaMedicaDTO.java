package com.agendas.entidadesDTO;

import java.util.Date;

public class CitaMedicaDTO {

	private Long id;
	private Boolean asignada;
	private Date fecha;
	private Long tipoCita;
	private Long usuario;
	private Long sintomatologia;
	private Long medico;
	
	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getAsignada() {
		return asignada;
	}
	public void setAsignada(Boolean asignada) {
		this.asignada = asignada;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Long getTipoCita() {
		return tipoCita;
	}
	public void setTipoCita(Long tipoCita) {
		this.tipoCita = tipoCita;
	}
	public Long getUsuario() {
		return usuario;
	}
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	public Long getSintomatologia() {
		return sintomatologia;
	}
	public void setSintomatologia(Long sintomatologia) {
		this.sintomatologia = sintomatologia;
	}
	public Long getMedico() {
		return medico;
	}
	public void setMedico(Long medico) {
		this.medico = medico;
	}
	
	
}
