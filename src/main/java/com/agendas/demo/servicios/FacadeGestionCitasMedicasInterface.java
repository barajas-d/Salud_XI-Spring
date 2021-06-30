package com.agendas.demo.servicios;

import com.agendas.demo.entidades.CitaMedica;
import com.agendas.entidadesDTO.CitaMedicaDTO;

public interface FacadeGestionCitasMedicasInterface {

	CitaMedica createCitaMedica(CitaMedicaDTO citaMedica);

	Boolean deleteCitaMedica(Long idCitaMedica);
	
	Iterable<CitaMedica> getCitasMedicasPorUsuario(Long cedulaUsuario);

}
