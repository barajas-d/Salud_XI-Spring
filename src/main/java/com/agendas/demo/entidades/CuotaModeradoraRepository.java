package com.agendas.demo.entidades;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CuotaModeradoraRepository extends JpaRepository<CuotaModeradora, Long>{

	CuotaModeradora findByTipoCitaAndTiposContrato(TipoCita tipoCita, TipoContrato tipoContrato);
}
