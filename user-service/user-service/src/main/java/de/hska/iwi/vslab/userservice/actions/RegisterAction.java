package de.hska.iwi.vslab.userservice.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.hska.iwi.vslab.userservice.controller.json.JSONRegistration;
import de.hska.iwi.vslab.userservice.db.dataobjects.Role;
import de.hska.iwi.vslab.userservice.manager.UserManager;

@Component
public class RegisterAction {

	private final UserManager userManager;

	@Autowired
	public RegisterAction(final UserManager userManager) {
		this.userManager = userManager;
	}

	public void register(final JSONRegistration jSONRegistration) throws Exception {
		Role role = userManager.getRoleByLevel(1); // 1 -> regular User, 2 -> Admin

		if (userManager.doesUserAlreadyExist(jSONRegistration.getUsername()))
			throw new IllegalStateException("User already exists!");

		if (!isValid(jSONRegistration))
			throw new IllegalArgumentException("Invalid user!");

		userManager.registerUser(jSONRegistration.getUsername(), jSONRegistration.getFirstname(),
				jSONRegistration.getLastname(), jSONRegistration.getPassword1(), role);
	}

	private boolean isValid(final JSONRegistration jSONRegistration) {
		if (jSONRegistration.getFirstname().isEmpty())
			return false;

		if (jSONRegistration.getLastname().isEmpty())
			return false;

		if (jSONRegistration.getUsername().isEmpty())
			return false;

		if (jSONRegistration.getPassword1().isEmpty())
			return false;

		if (jSONRegistration.getPassword2().isEmpty())
			return false;

		if (!jSONRegistration.getPassword1().equals(jSONRegistration.getPassword2()))
			return false;

		return true;
	}

}
