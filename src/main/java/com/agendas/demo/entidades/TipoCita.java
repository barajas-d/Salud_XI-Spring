package com.agendas.demo.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TIPOS_CITAS")
public class TipoCita {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "DURACION", nullable = false)
	private Long duracion;

	@OneToMany(mappedBy = "tipoCita")
	//@JsonManagedReference
	@JsonIgnore
	private List<CuotaModeradora> cuotasModeradora;

	@OneToMany(mappedBy = "tipoCita")
	//@JsonManagedReference
	@JsonIgnore
	private List<CitaMedica> citasMedicas;
	
	@OneToMany(mappedBy = "tipoCita")
	//@JsonManagedReference
	@JsonIgnore
	private List<TiposCitasAtendidasPorEspecialidad> tiposCitasAtendidasPorEspecialidades;
	
	//CONSTRUCTORES
	public TipoCita() {
		super();
	}
	
	public TipoCita(String nombre, Long duracion) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
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

	public Long getDuracion() {
		return duracion;
	}

	public void setDuracion(Long duracion) {
		this.duracion = duracion;
	}

	public List<CuotaModeradora> getCuotasModeradora() {
		return cuotasModeradora;
	}

	public void setCuotasModeradora(List<CuotaModeradora> cuotasModeradora) {
		this.cuotasModeradora = cuotasModeradora;
	}

	public List<CitaMedica> getCitasMedicas() {
		return citasMedicas;
	}

	public void setCitasMedicas(List<CitaMedica> citasMedicas) {
		this.citasMedicas = citasMedicas;
	}

	public List<TiposCitasAtendidasPorEspecialidad> getTiposCitasAtendidasPorEspecialidades() {
		return tiposCitasAtendidasPorEspecialidades;
	}

	public void setTiposCitasAtendidasPorEspecialidades(
			List<TiposCitasAtendidasPorEspecialidad> tiposCitasAtendidasPorEspecialidades) {
		this.tiposCitasAtendidasPorEspecialidades = tiposCitasAtendidasPorEspecialidades;
	}
	
}
