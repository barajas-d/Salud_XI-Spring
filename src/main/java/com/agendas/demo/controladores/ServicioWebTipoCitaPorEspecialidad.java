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

import com.agendas.demo.entidades.Especialidad;
import com.agendas.demo.entidades.TipoCita;
import com.agendas.demo.entidades.TiposCitasAtendidasPorEspecialidad;
import com.agendas.demo.entidadesDTO.TiposCitaPorEspecialidadDto;
import com.agendas.demo.servicios.FacadeGestionTipoDeCitaPorEspecialidadInterface;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("tipoCitaEspecialidad")
public class ServicioWebTipoCitaPorEspecialidad { 

	@Autowired
	private FacadeGestionTipoDeCitaPorEspecialidadInterface service;
	
	//Crear tipo de cita por especialidad
	@PostMapping("/add")
	public ResponseEntity<Object> creatTipoCitaPorEspecialidad(@RequestBody TiposCitaPorEspecialidadDto tiposCitaEspecialidad){
		TiposCitasAtendidasPorEspecialidad tiposCitaEspecialidadNuevo = service.createTipoDeCitaPorEspecialidad(tiposCitaEspecialidad);
		return new ResponseEntity<Object>(tiposCitaEspecialidadNuevo, HttpStatus.CREATED);
	}
	
	//Eliminar tipo de cita por especialidad
	@DeleteMapping("delete/{idTipoCitaEspecialidad}")
	public ResponseEntity<Object> deleteTipoCitaPorEspecialidad(@PathVariable Long idTipoCitaEspecialidad) {
		Boolean result = service.deleteTipoDeCitaPorEspecialidad(idTipoCitaEspecialidad);
		if(result) {
			return new ResponseEntity<Object>(result, HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<Object>(result, HttpStatus.NOT_FOUND);
		}
	}
	
	//Obtener tipos de cita por especialidades y paguinacion
	@GetMapping("/{inicial}/{cantidad}")
	public ResponseEntity<Object> getTiposCitaPorEspecialidad(@PathVariable int inicial, @PathVariable int cantidad){
		Iterable<TiposCitasAtendidasPorEspecialidad> tiposCitaEspecialidad = service.getTiposDeCitaPorEspecialidad(inicial, cantidad);
		return new ResponseEntity<Object>(tiposCitaEspecialidad, HttpStatus.ACCEPTED);
	}
	
	//obtener tipos de cita
	@GetMapping("/tiposCita")
	public ResponseEntity<Object> getTiposCita(){
		Iterable<TipoCita> tiposCita = service.getTipoCita();
		return new ResponseEntity<Object>(tiposCita, HttpStatus.ACCEPTED);
	}
	
	//obtener especialidades
	@GetMapping("/especialidades")
	public ResponseEntity<Object> getEspecialidades(){
		Iterable<Especialidad> especialidad = service.getEspecialidades();
		return new ResponseEntity<Object>(especialidad, HttpStatus.ACCEPTED);
	}
	
}
