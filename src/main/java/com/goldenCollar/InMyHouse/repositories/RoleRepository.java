package com.goldenCollar.InMyHouse.repositories;

import com.goldenCollar.InMyHouse.model.Role;
import com.goldenCollar.InMyHouse.model.RoleUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleUtilisateur name);
}
