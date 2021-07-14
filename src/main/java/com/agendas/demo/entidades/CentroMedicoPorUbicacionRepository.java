package com.agendas.demo.entidades;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CentroMedicoPorUbicacionRepository extends JpaRepository<CentroMedicoPorUbicacion, Long>{

	List<CentroMedicoPorUbicacion> findByCentroMedico(CentroMedico centroMedico, Pageable pageable);
 
}
