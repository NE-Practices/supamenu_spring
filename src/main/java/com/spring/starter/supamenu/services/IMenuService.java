package com.spring.starter.supamenu.services;

import com.spring.starter.supamenu.dtos.request.UpdateMenuDTO;
import com.spring.starter.supamenu.enums.EMenu;
import com.spring.starter.supamenu.models.MenuItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IMenuService {
    Page<MenuItem> getAll(Pageable pageable);

    MenuItem getById(UUID id);

    Page<MenuItem> getMenuByType(EMenu type, Pageable pageable);

    Page<MenuItem> searchMenu(String searchKey, Pageable pageable);

    MenuItem getMenuItem(UUID id);

    MenuItem create(MenuItem menuItem);

    boolean delete(UUID id);

    MenuItem update(UUID id, UpdateMenuDTO dto);
}
