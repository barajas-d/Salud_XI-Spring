package com.agendas.demo.servicios;

import com.agendas.demo.entidades.CentroMedico;
import com.agendas.demo.entidades.CentroMedicoPorUbicacion;
import com.agendas.demo.entidadesDTO.CentroMedicoDTO;
import com.agendas.demo.entidadesDTO.CentroMedicoPorUbicacionDTO;

public interface FacadeGestionCentrosMedicosInterface {

	public Integer getAllCentrosMedicos();
	
	//Crear centro m�dico
	public Boolean createCentroMedico(CentroMedicoDTO centroMedico);
	//Eliminar centro m�dico
	public Boolean deleteCentroMedico(Long idCentroMedico);
	//Actualizar centro m�dico
	public Boolean updateCentroMedico(CentroMedicoDTO centroMedico);
	//Obtener centros medicos con paginaci�n
	public Iterable<CentroMedico> getCentrosMedicos(int inicial, int cantidad);
	//Obtener ubicaciones de un centro medico
	public Iterable<CentroMedicoPorUbicacion> getUbicacionesCentroMedico(Long idCentroMedico, int inicial, int cantidad);
	//Agregar una ubicacion a un centro medico
	public CentroMedicoPorUbicacion createUbicacionCentroMedico(CentroMedicoPorUbicacionDTO ubicacionCentroMedico);
	//Eliminar una ubicacion a un centro medico
	public Boolean deleteUbicacionCentroMedico(Long idUbicacionCentroMedico);
	//obtener centro medico por id
	public CentroMedico getCentroMedico(Long idCentroMedico);
}
