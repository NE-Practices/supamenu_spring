package com.spring.starter.supamenu.repositories;

import com.spring.starter.supamenu.enums.ERole;
import com.spring.starter.supamenu.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IRoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(ERole role);
}