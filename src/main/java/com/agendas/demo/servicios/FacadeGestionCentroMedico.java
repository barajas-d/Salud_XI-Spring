package com.agendas.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendas.demo.entidades.CentroMedicoRepository;

@Service
public class FacadeGestionCentroMedico {

	@Autowired
	private CentroMedicoRepository repository;
	
	
}
