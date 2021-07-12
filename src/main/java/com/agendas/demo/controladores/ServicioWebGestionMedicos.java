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

import com.agendas.demo.entidades.CentroMedico;
import com.agendas.demo.entidades.Especialidad;
import com.agendas.demo.entidades.Medico;
import com.agendas.demo.entidadesDTO.MedicoDTO;
import com.agendas.demo.servicios.FacadeGestionMedicoInterface;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/medico")
public class ServicioWebGestionMedicos {

	@Autowired
	private FacadeGestionMedicoInterface service;
	
	//Crear medico
	@PostMapping("/add")
	public ResponseEntity<Object> createMedico(@RequestBody MedicoDTO medico) {
		Medico medicoNuevo = service.createMedico(medico);
		return new ResponseEntity<Object>(medicoNuevo, HttpStatus.CREATED);
	}
	
	//Actualizar medico
	@PutMapping("/update")
	public ResponseEntity<Object> updateMedico(@RequestBody MedicoDTO medico) {
		Medico medicoActualizado = service.updateMedico(medico);
		return new ResponseEntity<Object>(medicoActualizado, HttpStatus.CREATED);
	}
	
	//Eliminar medico
	@DeleteMapping("/delete/{idMedico}")
	public ResponseEntity<Object> deleteTipoCita(@PathVariable Long idMedico) {
		Boolean result = service.deleteMedico(idMedico);
		if(result) {
			return new ResponseEntity<Object>(result, HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<Object>(result, HttpStatus.NOT_FOUND);
		}
	}
	
	//Obtener lista de medicos con paginacion
	@GetMapping("/{inicial}/{cantidad}")
	public ResponseEntity<Object> getUsuarios(@PathVariable int inicial, @PathVariable int cantidad){
		Iterable<Medico> medicos = service.getMedicos(inicial, cantidad);
		return new ResponseEntity<Object>(medicos, HttpStatus.ACCEPTED);
	}
	
	//Obtener medico a partir de su cedula
	@GetMapping("/{cedulaMedico}")
	public ResponseEntity<Object> getMedico(@PathVariable Long cedulaMedico){
		Medico medico = service.getMedico(cedulaMedico);
		return new ResponseEntity<Object>(medico, HttpStatus.ACCEPTED);
	}
	
	//Obtener lista de especialidades
	@GetMapping("/especialidades")
	public ResponseEntity<Object> getEspecialidades(){
		Iterable<Especialidad> especialidades = service.getEspecialidades();
		return new ResponseEntity<Object>(especialidades, HttpStatus.ACCEPTED);
	}
	
	//Obtener lista de centros médicos
	@GetMapping("/centrosMedicos")
	public ResponseEntity<Object> getCentrosMedicos(){
		Iterable<CentroMedico> centrosMedicos = service.getCentrosMedicos();
		return new ResponseEntity<Object>(centrosMedicos, HttpStatus.ACCEPTED);
	}
}
