package com.agendas.demo.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendas.demo.entidades.CitaMedica;
import com.agendas.demo.entidades.CitaMedicaRepository;
import com.agendas.demo.entidades.Sintomatologia;
import com.agendas.demo.entidades.SintomatologiaRepository;
import com.agendas.demo.entidades.TipoCita;
import com.agendas.demo.entidades.TipoCitaRepository;
import com.agendas.demo.entidades.Usuario;
import com.agendas.demo.entidades.UsuarioRepository;
import com.agendas.entidadesDTO.CitaMedicaDTO;

@Service
public class FacadeGestionCitasMedicas implements FacadeGestionCitasMedicasInterface{

	@Autowired
	private CitaMedicaRepository citaMedicaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TipoCitaRepository tipoCitaRepository;
	
	@Autowired
	private SintomatologiaRepository sintomatologiaRepository;
	
	@Override
	public CitaMedica createCitaMedica(CitaMedicaDTO citaMedica){

		Optional<TipoCita> tipoCita = tipoCitaRepository.findById(citaMedica.getTipoCita());	
		Optional<Usuario> usuario = usuarioRepository.findById(citaMedica.getUsuario());
		Optional<Sintomatologia> sintomatologia = sintomatologiaRepository.findById(citaMedica.getSintomatologia());
			
		CitaMedica nuevaCitaMedica = new CitaMedica(tipoCita.get(), usuario.get(), sintomatologia.get());
		return citaMedicaRepository.save(nuevaCitaMedica);
	}
	
	@Override
	public Boolean deleteCitaMedica(Long idCitaMedica) {
		
		Optional<CitaMedica> citaMedicaEliminar = citaMedicaRepository.findById(idCitaMedica);
		
		if(citaMedicaEliminar.isPresent()) {
			if(citaMedicaEliminar.get().getAsignada() == false) {
				citaMedicaRepository.deleteById(idCitaMedica);
				return true;
			}
			else {
				//La cita medica ya esta asignada
			}
		}
		return false;
	}
	
	@Override
	public Iterable<CitaMedica> getCitasMedicasPorUsuario(Long cedulaUsuario) {
		Usuario usuario = usuarioRepository.findByCedula(cedulaUsuario);
		if(usuario != null) {
			Iterable<CitaMedica> citas = citaMedicaRepository.findByAsignadaAndUsuario(false, usuario);
			return citas;
		}
		return null;
	}
}
