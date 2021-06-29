package com.agendas.demo.servicios;

import com.agendas.demo.entidades.TipoCita;

public interface FacadeGestionTiposDeCitaInterface {

	public TipoCita createTipoCita(TipoCita tipoCita);

	public TipoCita updateTipoCita(TipoCita tipoCita);

	public TipoCita deleteTipoCita(Long idTipoDeCita);

	public Iterable<TipoCita> getTiposDeCita(int inicial, int cantidad);

	public TipoCita getTipoCita(Long idTipoCita);
}
