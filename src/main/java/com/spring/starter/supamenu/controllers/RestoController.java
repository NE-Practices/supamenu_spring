package com.spring.starter.supamenu.controllers;

import com.spring.starter.supamenu.dtos.request.CreateRestoDTO;
import com.spring.starter.supamenu.dtos.request.UpdateRestoDTO;
import com.spring.starter.supamenu.dtos.response.ApiResponse;
import com.spring.starter.supamenu.models.Resto;
import com.spring.starter.supamenu.services.IRestoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/restos")
public class RestoController {

    private final IRestoService restoService;

    public RestoController(IRestoService restoService) {
        this.restoService = restoService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllRestos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return ResponseEntity.ok(ApiResponse.success("Restos fetched", restoService.getAll(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getResto(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.success("Resto found", restoService.getById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createResto(@Valid @RequestBody CreateRestoDTO dto) {
        Resto resto = new Resto(dto.getName(),dto.getContactNumber(),dto.getCuisineType(),dto.getType(),dto.getPictures());
        return ResponseEntity.ok(ApiResponse.success("Resto created", restoService.create(resto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateResto(@PathVariable UUID id, @RequestBody UpdateRestoDTO dto) {
        return ResponseEntity.ok(ApiResponse.success("Resto updated", restoService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteResto(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.success("Resto deleted", restoService.delete(id)));
    }
}
