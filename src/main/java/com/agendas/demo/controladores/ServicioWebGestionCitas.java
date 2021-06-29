package com.agendas.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Cita")
public class ServicioWebGestionCitas {

	/*@Autowired
	private FacadeGestionCitasInterface service;
	
	@PostMapping()
	public createCita(@RequestBody Cita cita) {
		return null;
	}*/
}
