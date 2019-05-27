package de.hska.iwi.vslab.userservice.manager;

import de.hska.iwi.vslab.userservice.db.dataobjects.Role;
import de.hska.iwi.vslab.userservice.db.dataobjects.User;

public interface UserManager {
    
    public void registerUser(String username, String name, String lastname, String password, Role role);
    
    public User getUserByUsername(String username);
    
    public void deleteUserById(int id);
    
    public Role getRoleByLevel(int level);
    
    public boolean doesUserAlreadyExist(String username);
}
