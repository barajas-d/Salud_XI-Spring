package com.agendas.demo.servicios;

import com.agendas.demo.entidades.CitaMedica;
import com.agendas.demo.entidades.Sintomatologia;
import com.agendas.entidadesDTO.AgendaDto;
import com.agendas.entidadesDTO.CitaMedicaDTO;

public interface FacadeGestionCitasMedicasInterface {

	//Crear cita medica
	CitaMedica createCitaMedica(CitaMedicaDTO citaMedica);
	//eliminar cita medica sin agendar
	Boolean deleteCitaMedica(Long idCitaMedica);
	//obtener lista de citas medicas por cedula de usuario
	Iterable<CitaMedica> getCitasMedicasPorUsuario(Long cedulaUsuario);
	//obtener sintomatologias
	Iterable<Sintomatologia> getSintomatologias();
	
	//Obtener citas medicas agendadas basadas en fecha y medico
	Iterable<CitaMedica> getAgenda(AgendaDto agenda);
	//Obtener citas medicas sin agendar con paginación
	Iterable<CitaMedica> getCitasSinAgendar(int inicial, int cantidad);
	//Ejecutar proceso masivo, agendar citas
	Boolean AgendarCitas();
	//Obtener cantidad de citas medicas sin agendar
	Long getCantidadCitasSinAgendar();
}
