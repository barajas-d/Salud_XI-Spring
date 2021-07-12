package com.agendas.demo.entidadesDTO;

public class UsuarioDTO {


	private Long id;
	private String nombre;
	private Long cedula;
	private String correo;
	private Long tipoContrato;
	private Long ubicacion;
	
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
	public Long getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Long ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Long getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(Long tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	

	
}
