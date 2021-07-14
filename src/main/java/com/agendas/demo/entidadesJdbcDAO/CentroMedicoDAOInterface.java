package com.agendas.demo.entidadesJdbcDAO;

public interface CentroMedicoDAOInterface {

	
	//Registrar centro médico en la base de datos
	public Boolean create(CentroMedicoDAO nuevoCentroMedico);
	//Eliminar centro médico en la base de datos
	public Boolean delete(Long idCentroMedico);
	//Actualizar centro médico en la base de datos
	public Boolean update(CentroMedicoDAO centroMedicoActualizado);
	
}
