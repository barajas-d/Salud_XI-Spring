package com.agendas.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendas.demo.entidades.CitaMedica;
import com.agendas.demo.entidadesDTO.AgendaDto;
import com.agendas.demo.servicios.FacadeGestionCentrosMedicosInterface;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/centrosMedicos")
public class ServicioWebCentrosMedicos {

	@Autowired 
	FacadeGestionCentrosMedicosInterface service;
	
	//Obtener cantidad de centros medicos
	@GetMapping("")
	public ResponseEntity<Object> gerCantidadCitasSinAgendar(){
		Integer cantidadCitasSinAgendar = service.getAllCentrosMedicos();
		return new ResponseEntity<Object>(cantidadCitasSinAgendar, HttpStatus.ACCEPTED);
	}
}
