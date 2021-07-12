package com.agendas.demo.servicios;

import com.agendas.demo.entidades.TipoCita;
import com.agendas.demo.entidadesDTO.TipoCitaDTO;

public interface FacadeGestionTiposDeCitaInterface {

	public TipoCita createTipoCita(TipoCitaDTO tipoCita);

	public TipoCita updateTipoCita(TipoCitaDTO tipoCita);

	public Boolean deleteTipoCita(Long idTipoDeCita);

	public Iterable<TipoCita> getTiposDeCita(int inicial, int cantidad);

	public TipoCita getTipoCita(Long idTipoCita);
	
	public Iterable<TipoCita> getAllTiposDeCita();
}
