package com.facturacion.daycam.shared.usuario.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.daycam.shared.usuario.entities.UsuarioEntity;
import com.facturacion.daycam.shared.usuario.services.UsuarioServices;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioApi {

    private final UsuarioServices usuarioServices;

    public UsuarioApi() {
        this.usuarioServices = null;
    }

    @PostMapping("user")
	public UsuarioEntity login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		String token = usuarioServices.getJWTToken(username);
		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setUsuarioNombre(username);
		usuario.setToken(token);		
		return usuario;
		
	}
    
}
