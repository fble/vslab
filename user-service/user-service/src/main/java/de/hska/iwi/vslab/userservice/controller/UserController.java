package de.hska.iwi.vslab.userservice.controller;

import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="users/")
public class UserController {
	
	@PostMapping
	public Response create() {
		// Create user
		return Response.ok().build();
	}
	
	@GetMapping("login")
	public Response login() {
		// Login user
		return Response.ok().build();
	}
	
	@GetMapping("logout")
	public Response logout() {
		// Logout user
		return Response.ok().build();
	}

}
