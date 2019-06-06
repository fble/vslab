package de.hska.iwi.vslab.userservice.controller;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.hska.iwi.vslab.userservice.actions.LoginAction;
import de.hska.iwi.vslab.userservice.actions.LogoutAction;
import de.hska.iwi.vslab.userservice.actions.RegisterAction;
import de.hska.iwi.vslab.userservice.controller.json.JSONRegistration;
import de.hska.iwi.vslab.userservice.controller.json.JSONUser;

@RestController
@RequestMapping(value="users/")
public class UserController {
	
	private final RegisterAction registerAction;
	private final LoginAction loginAction;
	private final LogoutAction logoutAction;
	
	@Autowired
	public UserController(final RegisterAction registerAction, final LoginAction loginAction, final LogoutAction logoutAction) {
		this.registerAction = registerAction;
		this.loginAction = loginAction;
		this.logoutAction = logoutAction;
	}

	@PostMapping
	public Response create(@RequestBody final JSONRegistration jSONRegistration) {
		try {
			registerAction.register(jSONRegistration);
		} catch (Exception e) {
			return Response.serverError().build();
		}
		
		return Response.ok().build();
	}
	
	@PostMapping("login")
	public Response login(@RequestBody final JSONUser jSONUser) {
		try {
			loginAction.login(jSONUser);
		} catch (Exception e) {
			return Response.serverError().build();
		}
		
		return Response.ok().build();
	}
	
	@PostMapping("logout")
	public Response logout(@RequestBody final JSONUser jSONUser) {
		try {
			logoutAction.logout();
		} catch (Exception e) {
			return Response.serverError().build();
		}
		
		return Response.ok().build();
	}

}
