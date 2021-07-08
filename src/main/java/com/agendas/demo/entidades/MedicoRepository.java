package com.agendas.demo.entidades;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

	Medico findByCedula(Long cedulaMedico);
	
}
