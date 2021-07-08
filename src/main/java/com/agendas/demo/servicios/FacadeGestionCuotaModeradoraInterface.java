package com.agendas.demo.servicios;

import com.agendas.demo.entidades.CuotaModeradora;
import com.agendas.demo.entidades.TipoCita;
import com.agendas.demo.entidades.TipoContrato;
import com.agendas.entidadesDTO.CuotaModeradoraDTO;

public interface FacadeGestionCuotaModeradoraInterface {

	//crear nueva cuota moderadora
	public CuotaModeradora createCuotaModeradora(CuotaModeradoraDTO cuotaModeradora);
	//eliminar cuota moderadora
	public Boolean deleteCuotaModeradora(Long idCuotaModeradora);
	//obtener cuotas moderadoras con paginacion
	public Iterable<CuotaModeradora> getCuotasModeradoras(int inicial, int cantidad);
	//obtener tipos de cita
	public Iterable<TipoCita> getTipoCita();
	//obtener tipos de contrato
	public Iterable<TipoContrato> getTipoContrato();
	//obtener todas las cuotas moderadoras
	public Iterable<CuotaModeradora> getAll();
	//obtener valor cuota moderadora con base en tipo de cita y tipo de contrato
	public CuotaModeradora getValorCuotaModeradora(Long idTipoCita, Long idTipoContrato);
	
}
