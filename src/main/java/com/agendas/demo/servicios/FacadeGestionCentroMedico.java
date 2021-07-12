package com.agendas.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class FacadeGestionCentroMedico implements FacadeGestionCentrosMedicosInterface{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Integer getAllCentrosMedicos() {
		String query = "select count(*) from medicos";
		int result = jdbcTemplate.queryForObject(query, Integer.class);
		return result;
	}
	
}
