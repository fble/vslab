package de.hska.iwi.vslab.userservice.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.hska.iwi.vslab.userservice.db.dataAccessObjects.RoleDAO;
import de.hska.iwi.vslab.userservice.db.dataAccessObjects.UserDAO;
import de.hska.iwi.vslab.userservice.db.dataobjects.Role;
import de.hska.iwi.vslab.userservice.db.dataobjects.User;
import de.hska.iwi.vslab.userservice.manager.UserManager;

@Service
@Transactional
public class UserManagerImpl implements UserManager {

	private final UserDAO userDAO;
	private final RoleDAO roleDAO;

	@Autowired
	public UserManagerImpl(final UserDAO userDAO, final RoleDAO roleDAO) {
		this.userDAO = userDAO;
		this.roleDAO = roleDAO;
	}

	@Override
	public void registerUser(String username, String name, String lastname, String password, Role role) {
		User user = new User(username, name, lastname, password, role);

		userDAO.registerUser(user);
	}

	@Override
	public User getUserByUsername(String username) {
		if (username == null || username.isEmpty())
			return null;
		
		return userDAO.getUserByUsername(username);
	}

	@Override
	public void deleteUserById(int id) {
		userDAO.deleteUserById(id);
	}

	@Override
	public Role getRoleByLevel(int level) {
		return roleDAO.getRoleByLevel(level);
	}

	@Override
	public boolean doesUserAlreadyExist(String username) {
		User dbUser = userDAO.getUserByUsername(username);
		
		return dbUser != null;
	}

}
