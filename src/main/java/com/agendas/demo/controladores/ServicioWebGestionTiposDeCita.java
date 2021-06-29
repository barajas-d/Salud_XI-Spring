package com.agendas.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tiposDeCita")
public class ServicioWebGestionTiposDeCita{

	
	@Autowired
	private FacadeGestionTiposDeCitaInterface service;
	
	@PostMapping()
	public TipoCita createTipoCita(@RequestBody TipoCita tipoCita) {
		System.out.println("NOMBRE: " + tipoCita.getNombre());
		System.out.println("DURACION: " + tipoCita.getDuracion());
		return service.createTipoCita(tipoCita);
	}
	
	@PutMapping("/update")
	public TipoCita updateTipoCita(@RequestBody TipoCita tipoCita) {
		return service.updateTipoCita(tipoCita);
	}
	
	@DeleteMapping("/delete/{idTipoDeCita}")
	public TipoCita deleteTipoCita(@PathVariable Long idTipoDeCita) {
		return service.deleteTipoCita(idTipoDeCita);
	}
	
	@GetMapping("/{idTipoCita}")
	public TipoCita getTipoCita(@PathVariable Long idTipoCita) {
		return service.getTipoCita(idTipoCita);
	}
	
	@GetMapping("/{inicial}/{cantidad}")
	public Iterable<TipoCita> getTiposDeCita(@PathVariable int inicial, @PathVariable int cantidad){
		return service.getTiposDeCita(inicial, cantidad);
	}
	
}
