package com.agendas.demo.servicios;

import com.agendas.demo.entidades.CentroMedico;
import com.agendas.demo.entidades.Especialidad;
import com.agendas.demo.entidades.Medico;
import com.agendas.demo.entidadesDTO.MedicoDTO;

public interface FacadeGestionMedicoInterface {

	//Crear Medico
	public Medico createMedico(MedicoDTO medico);
	//Actualizar Medico
	public Medico updateMedico(MedicoDTO medico);
	//Eliminar Medico
	public Boolean deleteMedico(Long idMedico);
	//Obtener grupo de Medicos y paguinacion
	public Iterable<Medico> getMedicos(int inicial, int cantidad);
	//Obtener Medico por cedula
	public Medico getMedico(Long cedulaMedico);
	//Obtener especialidades
	public Iterable<Especialidad> getEspecialidades();
	//Obtener centros médicos
	public Iterable<CentroMedico> getCentrosMedicos();
}
