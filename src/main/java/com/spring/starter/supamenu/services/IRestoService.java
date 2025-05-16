package com.spring.starter.supamenu.services;

import com.spring.starter.supamenu.dtos.request.MenuDTO;
import com.spring.starter.supamenu.dtos.request.UpdateRestoDTO;
import com.spring.starter.supamenu.enums.ECuisine;
import com.spring.starter.supamenu.enums.ERestaurantType;
import com.spring.starter.supamenu.models.Resto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IRestoService {

    Page<Resto> getAll(Pageable pageable);

    Page<Resto> searchResto(String searchKey, Pageable pageable);

    Resto getById(UUID id);

    Resto create(Resto resto);

    Resto update(UUID id, UpdateRestoDTO dto);

    boolean delete(UUID id);

    Page<Resto> getRestoByType(ERestaurantType type, Pageable pageable);

    Page<Resto> getRestoByCuisine(ECuisine cuisine, Pageable pageable);

    Resto addMenuToResto(UUID restoId, MenuDTO menuDTO);

    Resto deleteMenuFromResto(UUID restoId, int menuIndex);
}