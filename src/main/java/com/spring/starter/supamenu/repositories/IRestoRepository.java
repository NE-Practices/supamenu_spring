package com.spring.starter.supamenu.repositories;

import com.spring.starter.supamenu.enums.ECuisine;
import com.spring.starter.supamenu.enums.ERestaurantType;
import com.spring.starter.supamenu.models.Resto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IRestoRepository extends JpaRepository<Resto, UUID> {
    Page<Resto> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Resto> findByType(ERestaurantType type, Pageable pageable);
    Page<Resto> findByCuisineType(ECuisine cuisine, Pageable pageable);
}