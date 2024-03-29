package com.carboard.center.api;

import com.carboard.center.service.BrandApiService;
import com.carboard.domain.brand.BrandDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class BrandApiController {
    private final BrandApiService brandApiService;

    @GetMapping("brands/{brand_id}")
    public ResponseEntity getBrand(@PathVariable("brand_id") Long brandId) {
        return ResponseEntity.ok(brandApiService.getBrand(brandId));
    }

    @GetMapping("brands")
    public ResponseEntity getBrands() {
        return ResponseEntity.ok(brandApiService.getBrands());
    }

    @PostMapping("brands")
    public ResponseEntity createBrand(@RequestBody BrandDto brandDto) {
        BrandDto saved = brandApiService.createBrand(brandDto.getName());
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(URI.create("")).body(saved);
    }

    @PutMapping("brands/{brand_id}")
    public ResponseEntity updateBrand(@PathVariable("brand_id") Long brandId, @RequestBody BrandDto brandDto) {
        return ResponseEntity.ok(brandApiService.updateBrand(brandId, brandDto.getName()));
    }
}
