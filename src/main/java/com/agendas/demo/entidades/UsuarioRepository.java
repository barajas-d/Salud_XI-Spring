package com.agendas.demo.entidades;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByCedula(Long cedulaUsuario);

}
