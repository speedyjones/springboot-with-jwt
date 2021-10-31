package com.jwt.token.repo;

import com.jwt.token.model.AppUser;
import com.jwt.token.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
