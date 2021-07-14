package com.agendas.demo.servicios;

import com.agendas.demo.entidades.TipoCita;
import com.agendas.demo.entidadesDTO.TipoCitaDTO;

public interface FacadeGestionTiposDeCitaInterface {

	//crear tipo de cita
	public TipoCita createTipoCita(TipoCitaDTO tipoCita);
	//actualizar tipo de cita
	public TipoCita updateTipoCita(TipoCitaDTO tipoCita);
	//eliminar tipo de cita
	public Boolean deleteTipoCita(Long idTipoDeCita);
	//obtener tipos de cita con paginación
	public Iterable<TipoCita> getTiposDeCita(int inicial, int cantidad);
	//obtener un tipo de cita por su id
	public TipoCita getTipoCita(Long idTipoCita);
	//obtener todos los tipos de cita
	public Iterable<TipoCita> getAllTiposDeCita();
}
