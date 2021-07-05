package com.agendas.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendas.demo.entidades.TipoCita;
import com.agendas.demo.servicios.FacadeGestionTiposDeCitaInterface;
import com.agendas.entidadesDTO.TipoCitaDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tiposDeCita")
public class ServicioWebGestionTiposDeCita{

	
	@Autowired
	private FacadeGestionTiposDeCitaInterface service;
	
	//Crear un tipo de cita
	@PostMapping("/add")
	public ResponseEntity<Object> createTipoCita(@RequestBody TipoCitaDTO tipoCita) {
		TipoCita tipoCitaNuevo = service.createTipoCita(tipoCita);
		return new ResponseEntity<Object>(tipoCitaNuevo, HttpStatus.CREATED);
	}
	
	//actualizar un tipo de cita
	@PutMapping("/update")
	public ResponseEntity<Object> updateTipoCita(@RequestBody TipoCitaDTO tipoCita) {
		TipoCita tipoCitaActualizado = service.updateTipoCita(tipoCita);
		return new ResponseEntity<Object>(tipoCitaActualizado, HttpStatus.CREATED);
	}
	
	//eliminar un tipo de cita
	@DeleteMapping("/delete/{idTipoDeCita}")
	public ResponseEntity<Object> deleteTipoCita(@PathVariable Long idTipoDeCita) {
		Boolean result = service.deleteTipoCita(idTipoDeCita);
		if(result) {
			return new ResponseEntity<Object>(result, HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<Object>(result, HttpStatus.NOT_FOUND);
		}
	}
	
	//obtener un tipo de cita dado su id
	@GetMapping("/{idTipoCita}")
	public ResponseEntity<Object> getTipoCita(@PathVariable Long idTipoCita) {
		TipoCita tipoCita = service.getTipoCita(idTipoCita);
		return new ResponseEntity<Object>(tipoCita, HttpStatus.ACCEPTED);
	}
	
	//obtener lista de tipos de cita, con paginacion
	@GetMapping("/{inicial}/{cantidad}")
	public ResponseEntity<Object> getTiposDeCita(@PathVariable int inicial, @PathVariable int cantidad){
		Iterable<TipoCita> tiposCitas = service.getTiposDeCita(inicial, cantidad);
		return new ResponseEntity<Object>(tiposCitas, HttpStatus.ACCEPTED);
	}
	
	//obtener todos los tipos de cita
	@GetMapping()
	public ResponseEntity<Object> getAllTiposDeCita(){
		Iterable<TipoCita> tiposCita = service.getAllTiposDeCita();
		return new ResponseEntity<Object>(tiposCita, HttpStatus.ACCEPTED);
	}
	
}
