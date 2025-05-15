package com.spring.starter.supamenu.repositories;

import com.spring.starter.supamenu.models.MenuItem;
import com.spring.starter.supamenu.models.Resto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IMenuRepository extends JpaRepository<MenuItem, UUID> {

    // Get all menus for a specific resto
//    List<MenuItem> findByResto(Resto resto);

//    // Optional: Get menus by resto id directly if you don't want to fetch the Resto object first
//    List<MenuItem> findByRestoId(UUID restoId);
}
