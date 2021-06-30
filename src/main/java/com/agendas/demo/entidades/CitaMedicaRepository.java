package com.agendas.demo.entidades;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Long>{
	List<CitaMedica> findByAsignada(Boolean asignada);
	List<CitaMedica> findByUsuario(Usuario usuario);
	List<CitaMedica> findByAsignadaAndUsuario(Boolean asignada, Usuario usuario);
}
