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
import com.agendas.entidadesDTO.CuotaModeradoraDTO;

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
		
		Optional<TipoCita> tipoCita = tipoCitaRepository.findById(cuotaModeradora.getTipoCita());
		System.out.println(tipoCita.get().getNombre());
		Optional<TipoContrato> tipoContrato = tipoContratoRepository.findById(cuotaModeradora.getTipoContrato());
		System.out.println(tipoContrato.get().getNombre());

		CuotaModeradora cuotaModeradoraNueva = new CuotaModeradora(cuotaModeradora.getValor(), tipoCita.get(), tipoContrato.get());
		
		return cuotaModeradoraRepository.save(cuotaModeradoraNueva);
	}

	
	@Override
	public Boolean deleteCuotaModeradora(Long idCuotaModeradora) {
		
		Optional<CuotaModeradora> cuotaModeradoraEliminar = cuotaModeradoraRepository.findById(idCuotaModeradora);
		
		if(cuotaModeradoraEliminar.isPresent()) {
			cuotaModeradoraRepository.deleteById(idCuotaModeradora);
			return true;
		}
		return false;
	}


	@Override
	public Iterable<CuotaModeradora> getCuotasModeradoras(int inicial, int cantidad) {

		PageRequest pageRequest = PageRequest.of(inicial, cantidad);
		Iterable<CuotaModeradora> cuotasModeradoras = cuotaModeradoraRepository.findAll(pageRequest);
		pageRequest.getPageNumber();
		
		return cuotasModeradoras;
	}
	
	
	
	
}
