package com.spring.starter.supamenu.controllers;

import com.spring.starter.supamenu.dtos.request.CreateMenuDTO;
import com.spring.starter.supamenu.dtos.request.UpdateMenuDTO;
import com.spring.starter.supamenu.dtos.response.ApiResponse;
import com.spring.starter.supamenu.models.MenuItem;
import com.spring.starter.supamenu.services.IMenuService;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/menus")
public class MenuController {

    private final IMenuService menuService;

    public MenuController(IMenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllMenus(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return ResponseEntity.ok(ApiResponse.success("Menus fetched", menuService.getAll(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getMenu(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.success("Menu found", menuService.getById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createMenu(@Valid @RequestBody CreateMenuDTO dto) {
        MenuItem menu = new MenuItem(dto.getName(), dto.getDescription(), dto.getPrice(),dto.getType(),dto.getPictures());
        return ResponseEntity.ok(ApiResponse.success("Menu created", menuService.create(menu)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateMenu(@PathVariable UUID id, @RequestBody UpdateMenuDTO dto) {
        return ResponseEntity.ok(ApiResponse.success("Menu updated", menuService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteMenu(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.success("Menu deleted", menuService.delete(id)));
    }
}
