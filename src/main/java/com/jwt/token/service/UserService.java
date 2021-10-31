package com.jwt.token.service;

import com.jwt.token.model.AppUser;
import com.jwt.token.model.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);

    List<AppUser>getUsers();
}
