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

import com.agendas.demo.entidades.CuotaModeradora;
import com.agendas.demo.servicios.FacadeGestionCuotaModeradoraInterface;
import com.agendas.entidadesDTO.CuotaModeradoraDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("cuotaModeradora")
public class ServicioWebGestionCuotaModeradora {
	
	@Autowired
	private FacadeGestionCuotaModeradoraInterface service;
	
	@GetMapping()
	public ResponseEntity<Object> getAll(){
		Iterable<CuotaModeradora> cuotasModeradoras = service.getAll();
		return new ResponseEntity<Object>(cuotasModeradoras, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> createCuotaModeradora(@RequestBody CuotaModeradoraDTO cuotaModeradora) {
		CuotaModeradora cuotaModeradoraNueva = service.createCuotaModeradora(cuotaModeradora);
		return new ResponseEntity<Object>(cuotaModeradoraNueva, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{idCuotaModeradora}")
	public ResponseEntity<Object> deleteCuotamoderadora(@PathVariable Long idCuotaModeradora) {
		Boolean result = service.deleteCuotaModeradora(idCuotaModeradora);
		if(result) {
			return new ResponseEntity<Object>(result, HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<Object>(result, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{inicial}/{cantidad}")
	public ResponseEntity<Object> getCuotasModeradoras(@PathVariable int inicial, @PathVariable int cantidad){
		Iterable<CuotaModeradora> cuotasModeradoras = service.getCuotasModeradoras(inicial, cantidad);
		
		return new ResponseEntity<Object>(cuotasModeradoras, HttpStatus.ACCEPTED);
	}
}
