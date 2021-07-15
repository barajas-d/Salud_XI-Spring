package com.agendas.demo.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.agendas.demo.entidades.TipoContrato;
import com.agendas.demo.entidades.TipoContratoRepository;
import com.agendas.demo.entidades.Ubicacion;
import com.agendas.demo.entidades.UbicacionRepository;
import com.agendas.demo.entidades.Usuario;
import com.agendas.demo.entidades.UsuarioRepository;
import com.agendas.demo.entidadesDTO.UsuarioDTO;

@Service
public class FacadeGestionUsuario implements FacadeGestionUsuarioInterface{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TipoContratoRepository tipoContratoRepository;
	
	@Autowired
	private UbicacionRepository ubicacionRepository;
	
	@Override
	public Usuario createUsuario(UsuarioDTO usuario) {
		try {
			Optional<TipoContrato> tipoContrato = tipoContratoRepository.findById(usuario.getTipoContrato());
			Optional<Ubicacion> ubicacion = ubicacionRepository.findById(usuario.getUbicacion());
			Usuario nuevoUsuario = new Usuario(usuario.getNombre(), usuario.getCedula(), usuario.getCorreo(), tipoContrato.get(), ubicacion.get());
			return usuarioRepository.save(nuevoUsuario);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Usuario updateUsuario(UsuarioDTO usuario) {
		try {			
			Optional<Usuario> usuarioActualizado = usuarioRepository.findById(usuario.getId());
			if(usuarioActualizado.isPresent()) {
				usuarioActualizado.get().setNombre(usuario.getNombre());
				usuarioActualizado.get().setCedula(usuario.getCedula());
				usuarioActualizado.get().setCorreo(usuario.getCorreo());
				Optional<TipoContrato> tipoContrato = tipoContratoRepository.findById(usuario.getTipoContrato());
				usuarioActualizado.get().setTipoContrato(tipoContrato.get());
				Optional<Ubicacion> ubicacion = ubicacionRepository.findById(usuario.getUbicacion());
				usuarioActualizado.get().setUbicacion(ubicacion.get());
				return usuarioRepository.save(usuarioActualizado.get());
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean deleteusuario(Long idUsuario) {
		try {
			Optional<Usuario> usuarioEliminar = usuarioRepository.findById(idUsuario);	
			if(usuarioEliminar.isPresent()) {
				usuarioRepository.deleteById(idUsuario);
				return true;
			}
			return false;			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Iterable<Usuario> getUsuarios(int inicial, int cantidad) {
		PageRequest pageRequest = PageRequest.of(inicial, cantidad);
		Iterable<Usuario> usuarios = usuarioRepository.findAll(pageRequest);	
		return usuarios;
	}

	@Override
	public Usuario getUsuario(Long idUsuario) {
		Optional<Usuario> usuarioObtenido = usuarioRepository.findById(idUsuario);
		if(usuarioObtenido.isPresent()) {
			return usuarioObtenido.get();
		}	
		return null;
	}

	@Override
	public Iterable<Ubicacion> getUbicaciones() {
		return ubicacionRepository.findAll();
	}

	@Override
	public Iterable<TipoContrato> getTipoContrato() {
		return tipoContratoRepository.findAll();
	}

	@Override
	public Usuario getUsuarioByCC(Long cedulaUsuario) {
		return usuarioRepository.findByCedula(cedulaUsuario);
	}


	
}
