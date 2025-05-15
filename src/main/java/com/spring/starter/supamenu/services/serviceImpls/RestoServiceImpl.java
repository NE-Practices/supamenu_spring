package com.spring.starter.supamenu.services.serviceImpls;

import com.spring.starter.supamenu.dtos.request.UpdateRestoDTO;
import com.spring.starter.supamenu.enums.ECuisine;
import com.spring.starter.supamenu.enums.ERestaurantType;
import com.spring.starter.supamenu.exceptions.BadRequestException;
import com.spring.starter.supamenu.exceptions.ResourceNotFoundException;
import com.spring.starter.supamenu.models.Resto;
import com.spring.starter.supamenu.repositories.IRestoRepository;
import com.spring.starter.supamenu.services.IRestoService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestoServiceImpl implements IRestoService {

    private final IRestoRepository restoRepository;

    @Override
    public Page<Resto> getAll(Pageable pageable) {
        return restoRepository.findAll(pageable);
    }

    @Override
    public Page<Resto> searchResto(String searchKey, Pageable pageable) {
        return null;
    }

    @Override
    public Resto getById(UUID id) {
        return restoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resto", "id", id.toString()));
    }

    @Override
    public Resto create(Resto resto) {
        try {
            return restoRepository.save(resto);
        } catch (DataIntegrityViolationException e) {
            throw new BadRequestException("Resto creation failed due to data integrity violation", e);
        }
    }

    @Override
    public Resto update(UUID id, UpdateRestoDTO dto) {
        Resto resto = getById(id);
        resto.setName(dto.getName());
        resto.setContactNumber(dto.getContactNumber());
        resto.setType(dto.getType());
        resto.setCuisineType(dto.getCuisineType());
        resto.setPictures(dto.getPictures());
        return restoRepository.save(resto);
    }

    @Override
    public boolean delete(UUID id) {
        Resto resto = getById(id);
        restoRepository.delete(resto);
        return true;
    }

    @Override
    public Page<Resto> getRestoByMenuItem(UUID menuId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Resto> getRestoByType(ERestaurantType type, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Resto> getRestoByCuisine(ECuisine cuisine, Pageable pageable) {
        return null;
    }
}
