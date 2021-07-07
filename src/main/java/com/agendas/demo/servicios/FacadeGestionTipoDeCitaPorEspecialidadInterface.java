package com.agendas.demo.servicios;

import com.agendas.demo.entidades.Especialidad;
import com.agendas.demo.entidades.TipoCita;
import com.agendas.demo.entidades.TiposCitasAtendidasPorEspecialidad;
import com.agendas.entidadesDTO.TiposCitaPorEspecialidadDto;

public interface FacadeGestionTipoDeCitaPorEspecialidadInterface {
	
	//Crear tipo de cita por especialidad
	public TiposCitasAtendidasPorEspecialidad createTipoDeCitaPorEspecialidad(TiposCitaPorEspecialidadDto usuario);
	//Eliminar tipo de cita por especialidad
	public Boolean deleteTipoDeCitaPorEspecialidad(Long idUsuario);
	//Obtener tipos de cita por especialidades y paguinacion
	public Iterable<TiposCitasAtendidasPorEspecialidad> getTiposDeCitaPorEspecialidad(int inicial, int cantidad);
	//obtener tipos de cita
	public Iterable<TipoCita> getTipoCita();
	//obtener especialidades
	public Iterable<Especialidad> getEspecialidades();
}
