package com.agendas.demo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "LOGIN")
public class Login {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "CORREO")
	private String correo;
	
	@Column(name = "CONTRASENA")
	private String contrasena;
	
	@Column(name = "ROL")
	private String rol; 
	
	//GETTERS AND SETTERS --------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
}
