package com.carboard.center.api;

import com.carboard.center.service.BrandApiService;
import com.carboard.domain.brand.BrandDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class BrandApiController {
    private final BrandApiService brandApiService;

    @GetMapping("brands/{brand_id}")
    public ResponseEntity<BrandDto> getBrand(@PathVariable("brand_id") Long brandId) {
        return ResponseEntity.ok(brandApiService.getBrand(brandId));
    }

    @GetMapping("brands")
    public void getBrands() {

    }

    @PostMapping("brands")
    public ResponseEntity<BrandDto> createBrand(String name) {
        BrandDto saved = brandApiService.createBrand(name);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(saved.getId()).toUri();

        return ResponseEntity.created(uri).body(saved);
    }
}
