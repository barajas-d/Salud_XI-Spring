package com.agendas.demo.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.agendas.demo.entidades.Especialidad;
import com.agendas.demo.entidades.EspecialidadRepository;
import com.agendas.demo.entidades.TipoCita;
import com.agendas.demo.entidades.TipoCitaRepository;
import com.agendas.demo.entidades.TiposCitasAtendidasPorEspecialidad;
import com.agendas.demo.entidades.TiposCitasAtendidasPorEspecialidadRepository;
import com.agendas.entidadesDTO.TiposCitaPorEspecialidadDto;

@Service
public class FacadeGestionTipoDeCitaPorEspecialidad implements FacadeGestionTipoDeCitaPorEspecialidadInterface{

	@Autowired
	private TiposCitasAtendidasPorEspecialidadRepository tipoCitaPorEspecialidadRepository;
	
	@Autowired
	private TipoCitaRepository tipoCitaRepository;
	
	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	@Override
	public TiposCitasAtendidasPorEspecialidad createTipoDeCitaPorEspecialidad(TiposCitaPorEspecialidadDto tipoCitaPorEspecialidad) {
		Optional<TipoCita> tipoCita = tipoCitaRepository.findById(tipoCitaPorEspecialidad.getTipoCita());
		Optional<Especialidad> especialidad = especialidadRepository.findById(tipoCitaPorEspecialidad.getEspecialidad());

		TiposCitasAtendidasPorEspecialidad tipoCitaPorEspecialidadNueva = new TiposCitasAtendidasPorEspecialidad(especialidad.get(), tipoCita.get());
		
		return tipoCitaPorEspecialidadRepository.save(tipoCitaPorEspecialidadNueva);
	}

	@Override
	public Boolean deleteTipoDeCitaPorEspecialidad(Long idTipoCitaPorEspecialidad) {
		Optional<TiposCitasAtendidasPorEspecialidad> tipoCitaPorEspecialidadEliminar = tipoCitaPorEspecialidadRepository.findById(idTipoCitaPorEspecialidad);
		
		if(tipoCitaPorEspecialidadEliminar.isPresent()) {
			tipoCitaPorEspecialidadRepository.deleteById(idTipoCitaPorEspecialidad);
			return true;
		}
		return false;
	}

	@Override
	public Iterable<TiposCitasAtendidasPorEspecialidad> getTiposDeCitaPorEspecialidad(int inicial, int cantidad) {
		PageRequest pageRequest = PageRequest.of(inicial, cantidad);
		Iterable<TiposCitasAtendidasPorEspecialidad> tiposCitaPorEspecialidadEliminar = tipoCitaPorEspecialidadRepository.findAll(pageRequest);
		
		return tiposCitaPorEspecialidadEliminar;
	}

	@Override
	public Iterable<TipoCita> getTipoCita() {
		return tipoCitaRepository.findAll();
	}

	@Override
	public Iterable<Especialidad> getEspecialidades() {
		return especialidadRepository.findAll();
	}

}
