package com.agendas.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendas.demo.entidades.CitaMedica;
import com.agendas.demo.entidadesDTO.AgendaDto;
import com.agendas.demo.servicios.FacadeGestionCitasMedicasInterface;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/agenda")
public class ServicioWebGestionAgendas {
	
	@Autowired
	private FacadeGestionCitasMedicasInterface service;
	
	//Obtener citas agendadas por cedula del medico y dia
	@PostMapping("")
	public ResponseEntity<Object> getAgenda(@RequestBody AgendaDto agenda){
		Iterable<CitaMedica> citasAgendadas = service.getAgenda(agenda);
		return new ResponseEntity<Object>(citasAgendadas, HttpStatus.ACCEPTED);
	}
	
	//Obtener citas sin agendar con paginacion
	@GetMapping("citasSinAgendar/{inicial}/{cantidad}")
	public ResponseEntity<Object> getCitasSinAgendar(@PathVariable int inicial, @PathVariable int cantidad){
		Iterable<CitaMedica> citasSinAgendar = service.getCitasSinAgendar(inicial, cantidad);
		return new ResponseEntity<Object>(citasSinAgendar, HttpStatus.ACCEPTED);
	}
	
	//Obtener cantidad de citas sin agendar
	@GetMapping("citasSinAgendar/cantidad")
	public ResponseEntity<Object> gerCantidadCitasSinAgendar(){
		Long cantidadCitasSinAgendar = service.getCantidadCitasSinAgendar();
		return new ResponseEntity<Object>(cantidadCitasSinAgendar, HttpStatus.ACCEPTED);
	}
	
	//Ejecutar proceso masivo
	@PostMapping("agendar")
	public ResponseEntity<Object> agendarCitas(){
		Boolean result = service.AgendarCitas();
		if(result) {			
			return new ResponseEntity<Object>(result, HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<Object>(result, HttpStatus.LOCKED);
		}
	}
}
