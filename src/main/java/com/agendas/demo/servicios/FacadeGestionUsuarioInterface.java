package com.agendas.demo.servicios;

import com.agendas.demo.entidades.Usuario;
import com.agendas.entidadesDTO.UsuarioDTO;

public interface FacadeGestionUsuarioInterface {

	//Crear usuario
	public Usuario createUsuario(UsuarioDTO usuario);
	//Actualizar usuario
	public Usuario updateUsuario(UsuarioDTO usuario);
	//Eliminar usuario
	public Boolean deleteusuario(Long idUsuario);
	//Obtener grupo de usuarios y paguinacion
	public Iterable<Usuario> getUsuarios(int inicial, int cantidad);
	//Obtener usuario
	public Usuario getUsuario(Long idUsuario);
}
