package com.agendas.demo.entidades;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Long>{
	
	@Procedure(name = "agendarCitas")
	void agendarCitas();
	
	List<CitaMedica> findByAsignada(Boolean asignada);
	List<CitaMedica> findByAsignada(Boolean asignada, Pageable pageable);
	List<CitaMedica> findByAsignadaOrderByUsuario(Boolean asignada, Pageable pageable);
	List<CitaMedica> findByUsuario(Usuario usuario);
	List<CitaMedica> findByAsignadaAndUsuario(Boolean asignada, Usuario usuario);
	List<CitaMedica> findByMedicoOrderByFecha(Medico medico);

}
