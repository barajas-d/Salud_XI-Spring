package com.agendas.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendas.demo.entidades.CuotaModeradora;
import com.agendas.demo.servicios.FacadeGestionCuotaModeradoraInterface;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("cuotaModeradora")
public class ServicioWebGestionCuotaModeradora {
	
	@Autowired
	private FacadeGestionCuotaModeradoraInterface service;
	
	@GetMapping()
	public Iterable<CuotaModeradora> getAll(){
		return service.getAll();
	}

}
