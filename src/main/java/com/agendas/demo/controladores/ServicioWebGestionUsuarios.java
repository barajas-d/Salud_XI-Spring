package com.agendas.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendas.demo.entidades.Usuario;
import com.agendas.demo.servicios.FacadeGestionUsuarioInterface;
import com.agendas.entidadesDTO.UsuarioDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")
public class ServicioWebGestionUsuarios {
	
	@Autowired
	private FacadeGestionUsuarioInterface service;

	//Crear un usuario
	@PostMapping("/add")
	public ResponseEntity<Object> createUsuario(@RequestBody UsuarioDTO usuario){
		Usuario usuarioNuevo = service.createUsuario(usuario);
		return new ResponseEntity<Object>(usuarioNuevo, HttpStatus.CREATED);
	}
	
	//Actualizar usuario
	@PutMapping("/update")
	public ResponseEntity<Object> updateUsuario(@RequestBody UsuarioDTO usuario){
		Usuario usuarioActualizado = service.updateUsuario(usuario);
		return new ResponseEntity<Object>(usuarioActualizado, HttpStatus.CREATED);
	}
	
	//Eliminar usuario
	@DeleteMapping("/delete/{idUsuario}")
	public ResponseEntity<Object> deleteUsuario(@PathVariable Long idUsuario){
		Boolean result = service.deleteusuario(idUsuario);
		if(result) {
			return new ResponseEntity<Object>(result, HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<Object>(result, HttpStatus.NOT_FOUND);
		}
	}
	
	//Obtener lista de usuarios con paginacion
	@GetMapping("/{inicial}/{cantidad}")
	public ResponseEntity<Object> getUsuarios(@PathVariable int inicial, @PathVariable int cantidad){
		Iterable<Usuario> usuarios = service.getUsuarios(inicial, cantidad);
		return new ResponseEntity<Object>(usuarios, HttpStatus.ACCEPTED);
	}
}