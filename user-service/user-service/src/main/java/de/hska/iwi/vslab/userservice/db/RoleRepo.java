package de.hska.iwi.vslab.userservice.db;

import org.springframework.data.repository.CrudRepository;

import de.hska.iwi.vslab.userservice.db.dataobjects.Role;

public interface RoleRepo extends CrudRepository<Role, Long> {
	
	public Role getRoleByLevel(int level);

}
