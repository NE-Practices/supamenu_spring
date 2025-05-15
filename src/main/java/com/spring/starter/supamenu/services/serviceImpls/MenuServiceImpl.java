package com.spring.starter.supamenu.services.serviceImpls;

import com.spring.starter.supamenu.dtos.request.UpdateMenuDTO;
import com.spring.starter.supamenu.enums.EMenu;
import com.spring.starter.supamenu.exceptions.BadRequestException;
import com.spring.starter.supamenu.exceptions.ResourceNotFoundException;
import com.spring.starter.supamenu.models.MenuItem;
import com.spring.starter.supamenu.repositories.IMenuRepository;
import com.spring.starter.supamenu.services.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements IMenuService {

    private final IMenuRepository menuRepository;

    @Override
    public Page<MenuItem> getAll(Pageable pageable) {
        return menuRepository.findAll(pageable);
    }

    @Override
    public MenuItem getById(UUID id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu", "id", id.toString()));
    }

    @Override
    public Page<MenuItem> getMenuByType(EMenu type, Pageable pageable) {
        return null;
    }

    @Override
    public Page<MenuItem> searchMenu(String searchKey, Pageable pageable) {
        return null;
    }

    @Override
    public MenuItem getMenuItem(UUID id) {
        return null;
    }

    @Override
    public MenuItem create(MenuItem menu) {
        try {
            return menuRepository.save(menu);
        } catch (DataIntegrityViolationException e) {
            throw new BadRequestException("Menu creation failed due to data integrity violation", e);
        }
    }

    @Override
    public MenuItem update(UUID id, UpdateMenuDTO dto) {
        MenuItem menu = getById(id);
        menu.setName(dto.getName());
        menu.setDescription(dto.getDescription());
        menu.setPrice(dto.getPrice());
        return menuRepository.save(menu);
    }

    @Override
    public boolean delete(UUID id) {
        MenuItem menu = getById(id);
        menuRepository.delete(menu);
        return true;
    }
}
