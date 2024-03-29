package com.agendas.demo.servicios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.agendas.demo.entidades.CitaMedica;
import com.agendas.demo.entidades.CitaMedicaRepository;
import com.agendas.demo.entidades.Medico;
import com.agendas.demo.entidades.MedicoRepository;
import com.agendas.demo.entidades.Sintomatologia;
import com.agendas.demo.entidades.SintomatologiaRepository;
import com.agendas.demo.entidades.TipoCita;
import com.agendas.demo.entidades.TipoCitaRepository;
import com.agendas.demo.entidades.Usuario;
import com.agendas.demo.entidades.UsuarioRepository;
import com.agendas.demo.entidadesDTO.AgendaDto;
import com.agendas.demo.entidadesDTO.CitaMedicaDTO;

@Service
public class FacadeGestionCitasMedicas implements FacadeGestionCitasMedicasInterface{

	@Autowired
	private CitaMedicaRepository citaMedicaRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TipoCitaRepository tipoCitaRepository;
	
	@Autowired
	private SintomatologiaRepository sintomatologiaRepository;
	
	@Override
	public CitaMedica createCitaMedica(CitaMedicaDTO citaMedica){
		try {
			Optional<TipoCita> tipoCita = tipoCitaRepository.findById(citaMedica.getTipoCita());	
			Usuario usuario = usuarioRepository.findByCedula(citaMedica.getUsuario());
			Optional<Sintomatologia> sintomatologia = sintomatologiaRepository.findById(citaMedica.getSintomatologia());			
			CitaMedica nuevaCitaMedica = new CitaMedica(tipoCita.get(), usuario, sintomatologia.get());
			return citaMedicaRepository.save(nuevaCitaMedica);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Boolean deleteCitaMedica(Long idCitaMedica) {
		try {
			Optional<CitaMedica> citaMedicaEliminar = citaMedicaRepository.findById(idCitaMedica);		
			if(citaMedicaEliminar.isPresent()) {
				citaMedicaRepository.deleteById(idCitaMedica);
				return true;
			}
			return false;			
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Iterable<CitaMedica> getCitasMedicasPorUsuario(Long cedulaUsuario, int inicial, int cantidad) {
		Usuario usuario = usuarioRepository.findByCedula(cedulaUsuario);
		if(usuario != null) {
			PageRequest pageRequest = PageRequest.of(inicial, cantidad);
			Iterable<CitaMedica> citas = citaMedicaRepository.findByUsuarioOrderByFechaDesc(usuario, pageRequest);
			return citas;
		}
		return null;
	}

	@Override
	public Iterable<Sintomatologia> getSintomatologias() {
		return sintomatologiaRepository.findAll();
	}

	@Override
	public Iterable<CitaMedica> getAgenda(AgendaDto agenda) {
		Medico medico = medicoRepository.findByCedula(agenda.getCedulaMedico());
		if(medico != null) {
			List<CitaMedica> citasFiltroFecha = new ArrayList<>();
			Iterable<CitaMedica> citasAgendadas = citaMedicaRepository.findByMedicoOrderByFecha(medico);
			
			for (CitaMedica citaMedica : citasAgendadas) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(citaMedica.getFecha());
				
				//Validar fechas indicadas con fechas de las citas
				System.out.println("Mes: " + calendar.get(Calendar.MONTH) + " A�O: " + calendar.get(Calendar.YEAR));
				if(calendar.get(Calendar.DAY_OF_MONTH) == agenda.getDia() && calendar.get(Calendar.MONTH)+1 == agenda.getMes() && calendar.get(Calendar.YEAR) == agenda.getAnio()) {
					System.out.println("Entro");
					citasFiltroFecha.add(citaMedica);
				}
			}
			
			return citasFiltroFecha;
		}
		return null;
	}

	@Override
	public Iterable<CitaMedica> getCitasSinAgendar(int inicial, int cantidad) {
		PageRequest pageRequest = PageRequest.of(inicial, cantidad);
		Iterable<CitaMedica> citasMedicas = citaMedicaRepository.findByAsignadaOrderByUsuario(false, pageRequest);
		return citasMedicas;
	}

	@Override
	public Long getCantidadCitasSinAgendar() {
		List<CitaMedica> citasMedicas = citaMedicaRepository.findByAsignada(false);
		return (long) citasMedicas.size();
	}

	@Override
	public Boolean AgendarCitas() {
		try {
			citaMedicaRepository.agendarCitas();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Integer getCantidadCitasMedicasPorUsuario(Long cedulaUsuario) {
		Usuario usuario = usuarioRepository.findByCedula(cedulaUsuario);
		if(usuario != null) {
			List<CitaMedica> citas = citaMedicaRepository.findByUsuario(usuario);
			return citas.size();
		}
		return null;
	}

}
