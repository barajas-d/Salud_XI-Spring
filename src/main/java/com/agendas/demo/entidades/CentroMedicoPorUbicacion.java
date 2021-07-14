package com.agendas.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CENTROS_MEDICOS_POR_UBICACION")
public class CentroMedicoPorUbicacion {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_CENTRO_MEDICO")
	private CentroMedico centroMedico;
	
	@ManyToOne
	@JoinColumn(name = "ID_UBICACION")
	private Ubicacion ubicacion;

	//CONSTRUCTORES
	public CentroMedicoPorUbicacion() {
		super();
	}

	public CentroMedicoPorUbicacion(CentroMedico centroMedico, Ubicacion ubicacion) {
		super();
		this.centroMedico = centroMedico;
		this.ubicacion = ubicacion;
	}


	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CentroMedico getCentroMedico() {
		return centroMedico;
	}

	public void setCentroMedico(CentroMedico centroMedico) {
		this.centroMedico = centroMedico;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	

	
}
