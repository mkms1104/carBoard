package com.carboard.center.service;

import com.carboard.domain.brand.Brand;
import com.carboard.domain.brand.BrandDto;
import com.carboard.domain.brand.BrandMapper;
import com.carboard.domain.brand.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BrandApiService {
    private final BrandRepository brandRepository;

    public BrandDto getBrand(Long brandId) {
        Optional<Brand> findBrandOp = brandRepository.findById(brandId);
        Brand findBrand = findBrandOp.orElseThrow(() -> { throw new IllegalArgumentException(""); } );
        return BrandMapper.INSTANCE.toDto(findBrand);
    }

    @Transactional
    public BrandDto createBrand(String name) {
        Brand saved = brandRepository.save(new Brand(name));
        return BrandMapper.INSTANCE.toDto(saved);
    }
}