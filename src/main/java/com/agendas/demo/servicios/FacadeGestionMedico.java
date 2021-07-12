package com.agendas.demo.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.agendas.demo.entidades.CentroMedico;
import com.agendas.demo.entidades.CentroMedicoRepository;
import com.agendas.demo.entidades.Especialidad;
import com.agendas.demo.entidades.EspecialidadRepository;
import com.agendas.demo.entidades.Medico;
import com.agendas.demo.entidades.MedicoRepository;
import com.agendas.demo.entidadesDTO.MedicoDTO;

@Service
public class FacadeGestionMedico implements FacadeGestionMedicoInterface{

	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	@Autowired
	private CentroMedicoRepository centroMedicoRepository;
	
	@Override
	public Medico createMedico(MedicoDTO medico) {
		Optional<Especialidad> especialidad = especialidadRepository.findById(medico.getEspecialidad());
		Optional<CentroMedico> centroMedico = centroMedicoRepository.findById(medico.getCentroMedico());
		
		Medico nuevoMedico = new Medico(medico.getNombre(), medico.getCedula(), medico.getIntensidadHoraria(), centroMedico.get(), especialidad.get());
		return medicoRepository.save(nuevoMedico);
	}

	@Override
	public Medico updateMedico(MedicoDTO medico) {
		Optional<Medico> medicoActualizado = medicoRepository.findById(medico.getId());
		if(medicoActualizado.isPresent()) {
			medicoActualizado.get().setNombre(medico.getNombre());
			medicoActualizado.get().setCedula(medico.getCedula());
			medicoActualizado.get().setIntensidadHoraria(medico.getIntensidadHoraria());
			Optional<CentroMedico> centroMedico = centroMedicoRepository.findById(medico.getCentroMedico());
			medicoActualizado.get().setCentroMedico(centroMedico.get());
			Optional<Especialidad> especialidad = especialidadRepository.findById(medico.getEspecialidad());
			medicoActualizado.get().setEspecialidad(especialidad.get());
			return medicoRepository.save(medicoActualizado.get());
		}
		return null;
	}

	@Override
	public Boolean deleteMedico(Long idMedico) {
		Optional<Medico> medicoEliminar = medicoRepository.findById(idMedico);	
		if(medicoEliminar.isPresent()) {
			medicoRepository.deleteById(idMedico);
			return true;
		}
		return false;
	}

	@Override
	public Iterable<Medico> getMedicos(int inicial, int cantidad) {
		PageRequest pageRequest = PageRequest.of(inicial, cantidad);
		Iterable<Medico> medicos = medicoRepository.findAll(pageRequest);	
		return medicos;
	}

	@Override
	public Medico getMedico(Long cedulaMedico) {
		Medico medicoObtenido = medicoRepository.findByCedula(cedulaMedico);
		if(medicoObtenido != null) {
			return medicoObtenido;
		}	
		return null;
	}

	@Override
	public Iterable<Especialidad> getEspecialidades() {
		return especialidadRepository.findAll();
	}

	@Override
	public Iterable<CentroMedico> getCentrosMedicos() {
		return centroMedicoRepository.findAll();
	}

}
