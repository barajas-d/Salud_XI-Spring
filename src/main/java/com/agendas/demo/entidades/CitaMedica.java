package com.agendas.demo.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "CITAS_MEDICAS")
public class CitaMedica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ASIGNADA")
	private Boolean asignada;
	
	@Column(name = "FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_CITA")
	@JsonBackReference
	private TipoCita tipoCita;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	@JsonBackReference
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "ID_SINTOMATOLOGIA")
	@JsonBackReference
	private Sintomatologia sintomatologia;
	
	@ManyToOne
	@JoinColumn(name = "ID_MEDICO", nullable = true)
	@JsonBackReference
	private Medico medico;
	
	public CitaMedica() {
		super();
	}
	
	public CitaMedica(TipoCita tipoCita, Usuario usuario, Sintomatologia sintomatologia) {
		super();
		this.asignada = false;
		this.fecha = null;
		this.tipoCita = tipoCita;
		this.usuario = usuario;
		this.sintomatologia = sintomatologia;
		this.medico = null;
	}

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

	public TipoCita getTipoCita() {
		return tipoCita;
	}

	public void setTipoCita(TipoCita tipoCita) {
		this.tipoCita = tipoCita;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Sintomatologia getSintomatologia() {
		return sintomatologia;
	}

	public void setSintomatologia(Sintomatologia sintomatologia) {
		this.sintomatologia = sintomatologia;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
}
