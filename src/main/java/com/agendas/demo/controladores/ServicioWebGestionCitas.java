package com.agendas.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendas.demo.entidades.CitaMedica;
import com.agendas.demo.entidades.Sintomatologia;
import com.agendas.demo.servicios.FacadeGestionCitasMedicasInterface;
import com.agendas.entidadesDTO.CitaMedicaDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cita")
public class ServicioWebGestionCitas {

	@Autowired
	private FacadeGestionCitasMedicasInterface service;
	
	
	//obtener citas medicas de un usuario
	@GetMapping("/{cedulaUsuario}")
	public ResponseEntity<Object> getCitasMedicasPorUsuario(@PathVariable Long cedulaUsuario) {
		
		Iterable<CitaMedica> citasMedicas = service.getCitasMedicasPorUsuario(cedulaUsuario);
		if(citasMedicas != null) {
			return new ResponseEntity<Object>(citasMedicas, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Object>(citasMedicas, HttpStatus.NOT_FOUND);
	}
	
	//crear una cita medica
	@PostMapping("/add")
	public ResponseEntity<Object> createCitaMedica(@RequestBody CitaMedicaDTO citaMedica){
		System.out.println("P1: " + citaMedica.getTipoCita() + ", " + citaMedica.getUsuario() + ", " + citaMedica.getSintomatologia());
		CitaMedica citaMedicaCreada = service.createCitaMedica(citaMedica);
		return new ResponseEntity<Object>(citaMedicaCreada, HttpStatus.CREATED);
	}
	
	//eliminar una cita medica
	@DeleteMapping("/delete/{idCitaMedica}")
	public ResponseEntity<Object> deleteCitaMedica(@PathVariable Long idCitaMedica){	
		Boolean result = service.deleteCitaMedica(idCitaMedica);	
		if(result) {
			return new ResponseEntity<Object>(result, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Object>(result, HttpStatus.NOT_FOUND);
	}
	
	//obtener sintomatologias para asociar a un cita
	@GetMapping("/sintomatologias")
	public ResponseEntity<Object> getSintomatologias(){
		Iterable<Sintomatologia> sintomatologias = service.getSintomatologias();
		return new ResponseEntity<Object>(sintomatologias, HttpStatus.ACCEPTED);
	}
}
