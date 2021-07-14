package com.agendas.demo.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.agendas.demo.entidades.CentroMedico;
import com.agendas.demo.entidades.CentroMedicoPorUbicacion;
import com.agendas.demo.entidades.CentroMedicoPorUbicacionRepository;
import com.agendas.demo.entidades.CentroMedicoRepository;
import com.agendas.demo.entidades.Ubicacion;
import com.agendas.demo.entidades.UbicacionRepository;
import com.agendas.demo.entidadesDTO.CentroMedicoDTO;
import com.agendas.demo.entidadesDTO.CentroMedicoPorUbicacionDTO;
import com.agendas.demo.entidadesJdbcDAO.CentroMedicoDAO;
import com.agendas.demo.entidadesJdbcDAO.CentroMedicoDAOInterface;

@Service
public class FacadeGestionCentroMedico implements FacadeGestionCentrosMedicosInterface{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CentroMedicoDAOInterface centroMedicoRepositoryJDBC;
	
	@Autowired
	private CentroMedicoPorUbicacionRepository ubicacionCentroMedicoRepository;
	
	@Autowired
	private CentroMedicoRepository centroMedicoRepository;
	
	@Autowired
	private UbicacionRepository ubicacionRepository;
	
	public Integer getAllCentrosMedicos() {
		String query = "select count(*) from medicos";
		int result = jdbcTemplate.queryForObject(query, Integer.class);
		return result;
	}

	@Override
	public Boolean createCentroMedico(CentroMedicoDTO centroMedico) {
		CentroMedicoDAO nuevoCentroMedico = new CentroMedicoDAO(centroMedico.getNombre());
		return centroMedicoRepositoryJDBC.create(nuevoCentroMedico);
	}

	@Override
	public Boolean deleteCentroMedico(Long idCentroMedico) {
		return centroMedicoRepositoryJDBC.delete(idCentroMedico);
	}

	@Override
	public Boolean updateCentroMedico(CentroMedicoDTO centroMedico) {
		CentroMedicoDAO centroMedicoActualizado = new CentroMedicoDAO(centroMedico.getId(), centroMedico.getNombre());
		return centroMedicoRepositoryJDBC.update(centroMedicoActualizado);
	}

	@Override
	public Iterable<CentroMedico> getCentrosMedicos(int inicial, int cantidad) {
		PageRequest pageRequest = PageRequest.of(inicial, cantidad);
		Iterable<CentroMedico> centrosMedicos = centroMedicoRepository.findAll(pageRequest);	
		return centrosMedicos;
	}

	@Override
	public Iterable<CentroMedicoPorUbicacion> getUbicacionesCentroMedico(Long idCentroMedico, int inicial, int cantidad) {
		Optional<CentroMedico> centroMedico = centroMedicoRepository.findById(idCentroMedico);
		if (centroMedico.isPresent()) {
			PageRequest pageRequest = PageRequest.of(inicial, cantidad);
			Iterable<CentroMedicoPorUbicacion> ubicacionCentrosMedicos = ubicacionCentroMedicoRepository.findByCentroMedico(centroMedico.get(), pageRequest);
			return ubicacionCentrosMedicos;
		}
		return null;
	}

	@Override
	public CentroMedicoPorUbicacion createUbicacionCentroMedico(CentroMedicoPorUbicacionDTO ubicacionCentroMedico) {
		Optional<CentroMedico> centroMedico = centroMedicoRepository.findById(ubicacionCentroMedico.getCentroMedico());
		Optional<Ubicacion> ubicacion = ubicacionRepository.findById(ubicacionCentroMedico.getUbicacion());
		
		CentroMedicoPorUbicacion nuevoCentroMedicoUbicacion = new CentroMedicoPorUbicacion(centroMedico.get(), ubicacion.get());
		return ubicacionCentroMedicoRepository.save(nuevoCentroMedicoUbicacion);
	}

	@Override
	public Boolean deleteUbicacionCentroMedico(Long idUbicacionCentroMedico) {
		Optional<CentroMedicoPorUbicacion> ubicacionCentroMedicoEliminar = ubicacionCentroMedicoRepository.findById(idUbicacionCentroMedico);	
		if(ubicacionCentroMedicoEliminar.isPresent()) {
			ubicacionCentroMedicoRepository.deleteById(idUbicacionCentroMedico);
			return true;
		}
		return false;
	}

	@Override
	public CentroMedico getCentroMedico(Long idCentroMedico) {
		Optional<CentroMedico> centroMedico = centroMedicoRepository.findById(idCentroMedico);
		if(centroMedico.isPresent()) {
			return centroMedico.get();
		}
		return null;
	}
	
}
