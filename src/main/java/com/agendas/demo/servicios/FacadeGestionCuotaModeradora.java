package com.agendas.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendas.demo.entidades.CuotaModeradora;
import com.agendas.demo.entidades.CuotaModeradoraRepository;

@Service
public class FacadeGestionCuotaModeradora implements FacadeGestionCuotaModeradoraInterface{

	@Autowired
	private CuotaModeradoraRepository repository;

	@Override
	public Iterable<CuotaModeradora> getAll() {

		Iterable<CuotaModeradora> cuotasModeradoras = repository.findAll();
		for (CuotaModeradora cuotaModeradora : cuotasModeradoras) {
			System.out.println("CUOTA: " + ((CuotaModeradora) cuotasModeradoras).getTiposCita().getNombre());
		}
		return cuotasModeradoras;
	}
	
	
}
