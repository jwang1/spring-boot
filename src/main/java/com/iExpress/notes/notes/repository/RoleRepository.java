package com.iExpress.notes.notes.repository;

import com.iExpress.notes.notes.model.Role;
import com.iExpress.notes.notes.model.RoleName;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository {
    Optional<Role> findByName(RoleName name);
}
