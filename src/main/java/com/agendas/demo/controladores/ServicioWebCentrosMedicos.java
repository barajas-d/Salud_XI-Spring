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
import com.agendas.demo.entidades.CentroMedicoPorUbicacion;
import com.agendas.demo.entidadesDTO.CentroMedicoDTO;
import com.agendas.demo.entidadesDTO.CentroMedicoPorUbicacionDTO;
import com.agendas.demo.servicios.FacadeGestionCentrosMedicosInterface;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/centrosMedicos")
public class ServicioWebCentrosMedicos {

	@Autowired 
	FacadeGestionCentrosMedicosInterface service;
	
	//Obtener cantidad de centros medicos
	@GetMapping("")
	public ResponseEntity<Object> getCantidadCitasSinAgendar(){
		Integer cantidadCitasSinAgendar = service.getAllCentrosMedicos();
		return new ResponseEntity<Object>(cantidadCitasSinAgendar, HttpStatus.ACCEPTED);
	}
	
	//Obtener centro medico por id
	@GetMapping("/{idCentroMedico}")
	public ResponseEntity<Object> getCentroMedio(@PathVariable Long  idCentroMedico){
		CentroMedico centroMedico = service.getCentroMedico(idCentroMedico);
		return new ResponseEntity<Object>(centroMedico, HttpStatus.ACCEPTED);
	}
	
	//Crear centro medico
	@PostMapping("/add")
	public ResponseEntity<Object> createCentroMedico(@RequestBody CentroMedicoDTO centroMedicoDto){
		Boolean centroMedicoCreado = service.createCentroMedico(centroMedicoDto);
		if(centroMedicoCreado == null) {
			return new ResponseEntity<Object>(null, HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<Object>(centroMedicoCreado, HttpStatus.CREATED);
		}
	}
	
	//Actualizar centro medico
	@PutMapping("/update")
	public ResponseEntity<Object> updateUsuario(@RequestBody CentroMedicoDTO centroMedicoDto){
		Boolean usuarioActualizado = service.updateCentroMedico(centroMedicoDto);		
		return new ResponseEntity<Object>(usuarioActualizado, HttpStatus.CREATED);
	}
	
	//eliminar centro medico
	@DeleteMapping("/delete/{idCentroMedico}")
	public ResponseEntity<Object> deleteUsuario(@PathVariable Long idCentroMedico){
		Boolean result = service.deleteCentroMedico(idCentroMedico);
		return new ResponseEntity<Object>(result, HttpStatus.ACCEPTED);
	}
	
	//Obtener centros medicos con paginación
	@GetMapping("/{inicial}/{cantidad}")
	public ResponseEntity<Object> getCentrosMedicos(@PathVariable int inicial, @PathVariable int cantidad){
		Iterable<CentroMedico> centrosMedicos = service.getCentrosMedicos(inicial, cantidad);
		return new ResponseEntity<Object>(centrosMedicos, HttpStatus.ACCEPTED);
	}
	
	//Obtener ubicaciones de un centro medico
	@GetMapping("ubicaciones/{idCentroMedico}/{inicial}/{cantidad}")
	public ResponseEntity<Object> getUbicacionesCentroMedico(@PathVariable Long idCentroMedico, @PathVariable int inicial, @PathVariable int cantidad){
		Iterable<CentroMedicoPorUbicacion> centrosMedicos = service.getUbicacionesCentroMedico(idCentroMedico, inicial, cantidad);
		return new ResponseEntity<Object>(centrosMedicos, HttpStatus.ACCEPTED);
	}
	
	//Agregar una ubicacion a un centro medico
	@PostMapping("/ubicacion/add")
	public ResponseEntity<Object> createUbicacionCentroMedico(@RequestBody CentroMedicoPorUbicacionDTO ubicacionCentroMedico){
		CentroMedicoPorUbicacion ubicacionCentroMedicoNuevo = service.createUbicacionCentroMedico(ubicacionCentroMedico);
		if(ubicacionCentroMedicoNuevo == null) {
			return new ResponseEntity<Object>(null, HttpStatus.ACCEPTED);
		}
		else {			
			return new ResponseEntity<Object>(ubicacionCentroMedicoNuevo, HttpStatus.ACCEPTED);
		}
	}
	
	//Eliminar una ubicacion a un centro medico
	@DeleteMapping("/ubicacion/delete/{idUbicacionCentroMedico}")
	
	public ResponseEntity<Object> deleteUbicacionCentroMedico(@PathVariable Long idUbicacionCentroMedico){
		Boolean result = service.deleteUbicacionCentroMedico(idUbicacionCentroMedico);
		if(result) {
			return new ResponseEntity<Object>(result, HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<Object>(result, HttpStatus.NOT_FOUND);
		}
	}
	
}
