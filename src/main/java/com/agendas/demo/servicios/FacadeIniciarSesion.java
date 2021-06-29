package com.agendas.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agendas.demo.entidades.Login;
import com.agendas.demo.entidades.LoginRepository;
import com.agendas.entidadesDTO.LoginDTO;

@RestController
@CrossOrigin(origins = "*")
public class FacadeIniciarSesion {

	@Autowired
	private LoginRepository repository;
	
	@PostMapping("/login")
	public Login createLogin(@RequestBody LoginDTO loginDTO) {
		if(loginDTO.getContrasena().equals("Mundo")) {
			Login login = new Login();
			login.setCorreo("No funciona");
			login.setContrasena(loginDTO.getContrasena());
			login.setRol(loginDTO.getRol());
			return repository.save(login);
		}
		else {
			Login login = new Login();
			login.setCorreo(loginDTO.getCorreo());
			login.setContrasena(loginDTO.getContrasena());
			login.setRol(loginDTO.getRol());
			return repository.save(login);
		}	
	}
}
