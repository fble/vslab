package de.hska.iwi.vslab.userservice.db;

import org.springframework.data.repository.CrudRepository;

import de.hska.iwi.vslab.userservice.db.dataobjects.User;

public interface UserRepo extends CrudRepository<User, Long> {
	
	public User findByUsername(final String name);
	
	public boolean existsByUsername(final String name);

}
