package com.agendas.demo.controladores;

import java.util.HashMap;

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
import com.agendas.demo.entidadesDTO.CitaMedicaDTO;
import com.agendas.demo.servicios.FacadeGestionCitasMedicasInterface;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cita")
public class ServicioWebGestionCitas {

	@Autowired
	private FacadeGestionCitasMedicasInterface service;
	
	
	//obtener citas medicas de un usuario
	@GetMapping("/{cedulaUsuario}/{page}/{size}")
	public ResponseEntity<Object> getCitasMedicasPorUsuario(@PathVariable Long cedulaUsuario, @PathVariable int page, @PathVariable int size) {
		Iterable<CitaMedica> citasMedicas = service.getCitasMedicasPorUsuario(cedulaUsuario, page, size);
		Integer cantidadCitasUsuario = service.getCantidadCitasMedicasPorUsuario(cedulaUsuario);
		
		HashMap<String, Object> jsonEnviar = new HashMap<String, Object>();
		jsonEnviar.put("content", citasMedicas);
		jsonEnviar.put("totalElements", cantidadCitasUsuario);
		if(citasMedicas != null) {
			return new ResponseEntity<Object>(jsonEnviar, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
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
		System.out.println("idCita: " + idCitaMedica);
		Boolean result = service.deleteCitaMedica(idCitaMedica);
		System.out.println("estado: " + result);
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
