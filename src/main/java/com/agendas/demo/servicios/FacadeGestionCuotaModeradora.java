package com.agendas.demo.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.agendas.demo.entidades.CuotaModeradora;
import com.agendas.demo.entidades.CuotaModeradoraRepository;
import com.agendas.demo.entidades.TipoCita;
import com.agendas.demo.entidades.TipoCitaRepository;
import com.agendas.demo.entidades.TipoContrato;
import com.agendas.demo.entidades.TipoContratoRepository;
import com.agendas.demo.entidadesDTO.CuotaModeradoraDTO;

@Service
public class FacadeGestionCuotaModeradora implements FacadeGestionCuotaModeradoraInterface{

	@Autowired
	private CuotaModeradoraRepository cuotaModeradoraRepository;
	@Autowired
	private TipoCitaRepository tipoCitaRepository;
	@Autowired
	private TipoContratoRepository tipoContratoRepository;

	@Override
	public Iterable<CuotaModeradora> getAll() {

		Iterable<CuotaModeradora> cuotasModeradoras = cuotaModeradoraRepository.findAll();
		return cuotasModeradoras;
	}


	@Override
	public CuotaModeradora createCuotaModeradora(CuotaModeradoraDTO cuotaModeradora) {
		try {
			Optional<TipoCita> tipoCita = tipoCitaRepository.findById(cuotaModeradora.getTipoCita());
			Optional<TipoContrato> tipoContrato = tipoContratoRepository.findById(cuotaModeradora.getTipoContrato());
			CuotaModeradora cuotaModeradoraNueva = new CuotaModeradora(cuotaModeradora.getValor(), tipoCita.get(), tipoContrato.get());	
			return cuotaModeradoraRepository.save(cuotaModeradoraNueva);			
		} catch (Exception e) {
			return null;
		}
	}

	
	@Override
	public Boolean deleteCuotaModeradora(Long idCuotaModeradora) {
		try {
			Optional<CuotaModeradora> cuotaModeradoraEliminar = cuotaModeradoraRepository.findById(idCuotaModeradora);
			if(cuotaModeradoraEliminar.isPresent()) {
				cuotaModeradoraRepository.deleteById(idCuotaModeradora);
				return true;
			}
			return false;			
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public Iterable<CuotaModeradora> getCuotasModeradoras(int inicial, int cantidad) {

		PageRequest pageRequest = PageRequest.of(inicial, cantidad);
		Iterable<CuotaModeradora> cuotasModeradoras = cuotaModeradoraRepository.findAll(pageRequest);
		
		return cuotasModeradoras;
	}


	@Override
	public Iterable<TipoCita> getTipoCita() {
		return tipoCitaRepository.findAll();
	}


	@Override
	public Iterable<TipoContrato> getTipoContrato() {
		return tipoContratoRepository.findAll();
	}


	@Override
	public CuotaModeradora getValorCuotaModeradora(Long idTipoCita, Long idTipoContrato) {
		Optional<TipoCita> tipoCita = tipoCitaRepository.findById(idTipoCita);
		Optional<TipoContrato> tipoContrato = tipoContratoRepository.findById(idTipoContrato);
		CuotaModeradora cuotaModeradora = cuotaModeradoraRepository.findByTipoCitaAndTiposContrato(tipoCita.get(), tipoContrato.get());
		return cuotaModeradora;
	}
	
}
