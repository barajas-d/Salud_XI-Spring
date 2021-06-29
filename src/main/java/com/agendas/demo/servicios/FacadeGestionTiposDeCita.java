package com.agendas.demo.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.agendas.demo.entidades.TipoCita;
import com.agendas.demo.entidades.TipoCitaRepository;

@Service
public class FacadeGestionTiposDeCita implements FacadeGestionTiposDeCitaInterface{

	@Autowired
	private TipoCitaRepository repository;
	
	
	//Crear tipo de cita
	@Override
	public TipoCita createTipoCita(TipoCita tipoCita) {
		return repository.save(tipoCita);
	}
	

	//Actualizar tipo de cita
	@Override
	public TipoCita updateTipoCita(TipoCita tipoCita) {
		
		Optional<TipoCita> tipoCitaActualizado = repository.findById(tipoCita.getId());
		
		if(tipoCitaActualizado.isPresent()){
			tipoCitaActualizado.get().setNombre(tipoCita.getNombre());
			tipoCitaActualizado.get().setDuracion(tipoCita.getDuracion());
			return repository.save(tipoCitaActualizado.get());
		}
		
		return null;
			
	}


	//Eliminar tipo de cita
	@Override
	public TipoCita deleteTipoCita(Long idTipoDeCita) {

		Optional<TipoCita> tipoCitaEliminar = repository.findById(idTipoDeCita);
		
		if(tipoCitaEliminar.isPresent()) {
			repository.deleteById(idTipoDeCita);
			return tipoCitaEliminar.get();
		}
		return null;
	}


	//Obtener grupo de tipos de cita
	@Override
	public Iterable<TipoCita> getTiposDeCita(int inicial, int cantidad) {

		PageRequest pageRequest = PageRequest.of(inicial, cantidad);
		Iterable<TipoCita> TiposDeCitas = repository.findAll(pageRequest);
		
		return TiposDeCitas;
	}


	//Obtener un tipo de cita
	@Override
	public TipoCita getTipoCita(Long idTipoCita) {

		Optional<TipoCita> tipoCitaObtenido = repository.findById(idTipoCita);
		
		//if(tipoCitaObtenido .isPresent()) {
			return tipoCitaObtenido.get();
		//}
		
		//return null;
	}
	
	
	
}
