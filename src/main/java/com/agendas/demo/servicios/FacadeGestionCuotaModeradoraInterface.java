package com.agendas.demo.servicios;

import com.agendas.demo.entidades.CuotaModeradora;
import com.agendas.entidadesDTO.CuotaModeradoraDTO;

public interface FacadeGestionCuotaModeradoraInterface {

	Iterable<CuotaModeradora> getAll();

	CuotaModeradora createCuotaModeradora(CuotaModeradoraDTO cuotaModeradora);

	Boolean deleteCuotaModeradora(Long idCuotaModeradora);

	Iterable<CuotaModeradora> getCuotasModeradoras(int inicial, int cantidad);
	
}
