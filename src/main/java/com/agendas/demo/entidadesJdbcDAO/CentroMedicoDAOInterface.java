package com.agendas.demo.entidadesJdbcDAO;

public interface CentroMedicoDAOInterface {

	
	//Registrar centro m�dico en la base de datos
	public Boolean create(CentroMedicoDAO nuevoCentroMedico);
	//Eliminar centro m�dico en la base de datos
	public Boolean delete(Long idCentroMedico);
	//Actualizar centro m�dico en la base de datos
	public Boolean update(CentroMedicoDAO centroMedicoActualizado);
	
}
