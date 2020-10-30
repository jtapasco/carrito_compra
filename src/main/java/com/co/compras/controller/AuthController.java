package com.co.compras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.compras.entity.User;
import com.co.compras.service.AuthService;

/**
 * Clase encargada la sesion del usuario
 * 
 * @author Jesica Tapasco Velez
 *
 */
@RestController
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	/**
	 * Método encargado de realizar la autenticación del usuario.
	 * 
	 * @param username
	 * @param pwd
	 * @return {@User}
	 */
	@PostMapping("/login")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

		String token = authService.getJWTToken(username, pwd);
		User user = new User();
		user.setUsername(username);
		user.setToken(token);
		return user;

	}

}
