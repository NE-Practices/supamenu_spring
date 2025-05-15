package com.spring.starter.supamenu.repositories;

import com.spring.starter.supamenu.models.Resto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IRestoRepository extends JpaRepository<Resto, UUID> {

    // Find resto by ownerId (used in getMyResto or user-specific actions)
//    Optional<Resto> findByOwnerId(UUID ownerId);

    // Optional: if ownerId is a string
    // Optional<Resto> findByOwnerId(String ownerId);
}
