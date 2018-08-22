package com.iExpress.notes.notes.repository;

import com.iExpress.notes.notes.model.Role;
import com.iExpress.notes.notes.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
