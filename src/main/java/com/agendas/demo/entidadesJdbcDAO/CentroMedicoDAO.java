package com.agendas.demo.entidadesJdbcDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CentroMedicoDAO implements CentroMedicoDAOInterface{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private Long id;
	private String nombre;
	
	public CentroMedicoDAO(Long pid, String pnombre) {
		this.id = pid;
		this.nombre = pnombre;
	}
	
	public CentroMedicoDAO(){}
	
	public CentroMedicoDAO(String pnombre) {
		this.id = null;
		this.nombre = pnombre;
	}
	
	//Registrar centro médico en la base de datos
	public Boolean create(CentroMedicoDAO nuevoCentroMedico) {
		String query = "INSERT INTO centros_medicos(nombre) VALUES ('" + nuevoCentroMedico.nombre + "')";
		Integer result = jdbcTemplate.update(query);
		if(result == 1) {
			return true;
		}
		else {			
			return false;
		}
	}

	//Eliminar centro médico en la base de datos
	@Override
	public Boolean delete(Long idCentroMedico) {
		String query = "DELETE FROM centros_medicos WHERE id = " + idCentroMedico;
		Integer result = jdbcTemplate.update(query);
		if(result == 1) {
			return true;
		}
		else {			
			return false;
		}
	}

	//Actualizar centro médico en la base de datos
	@Override
	public Boolean update(CentroMedicoDAO centroMedicoActualizado) {
		String query = "UPDATE centros_medicos SET nombre = '" + centroMedicoActualizado.nombre + "' WHERE id = " + centroMedicoActualizado.id;
		Integer result = jdbcTemplate.update(query);
		if(result == 1) {
			return true;
		}
		else {			
			return false;
		}
	}

}
