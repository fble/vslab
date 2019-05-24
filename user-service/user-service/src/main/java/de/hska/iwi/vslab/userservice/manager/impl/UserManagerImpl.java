package de.hska.iwi.vslab.userservice.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.hska.iwi.vslab.userservice.db.dataAccessObjects.RoleDAO;
import de.hska.iwi.vslab.userservice.db.dataAccessObjects.UserDAO;
import de.hska.iwi.vslab.userservice.db.dataobjects.Role;
import de.hska.iwi.vslab.userservice.db.dataobjects.User;
import de.hska.iwi.vslab.userservice.manager.UserManager;

@Component
public class UserManagerImpl implements UserManager {
	
	private final UserDAO userDAO;
	
	@Autowired
	public UserManagerImpl(final UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	
	public void registerUser(String username, String name, String lastname, String password, Role role) {
		User user = new User(username, name, lastname, password, role);

		userDAO.saveObject(user);
	}

	
	public User getUserByUsername(String username) {
		if (username == null || username.equals("")) {
			return null;
		}
		return userDAO.getUserByUsername(username);
	}

	public boolean deleteUserById(int id) {
		User user = new User();
		user.setId(id);
		userDAO.deleteObject(user);
		return true;
	}

	public Role getRoleByLevel(int level) {
		RoleDAO roleHelper = new RoleDAO();
		return roleHelper.getRoleByLevel(level);
	}

	public boolean doesUserAlreadyExist(String username) {
		
    	User dbUser = this.getUserByUsername(username);
    	
    	if (dbUser != null){
    		return true;
    	}
    	else {
    		return false;
    	}
	}
	

	public boolean validate(User user) {
		if (user.getFirstname().isEmpty() || user.getPassword().isEmpty() || user.getRole() == null || user.getLastname() == null || user.getUsername() == null) {
			return false;
		}
		
		return true;
	}

}
