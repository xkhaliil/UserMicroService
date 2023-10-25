package com.khalil.microsservice.service;

import com.khalil.microsservice.entities.Role;
import com.khalil.microsservice.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername (String username);
    Role addRole(Role role);
    User addRoleToUser(long id, Role r);

    List<User> findAllUsers();

    User findUserById(Long id);

    List<Role> findAllRoles();

    Role findRoleById(Long id);


    void deleteUser(long id);

    User removeRoleFromUser(long id, Role r);

    User activateUser(String username , String code);


}

