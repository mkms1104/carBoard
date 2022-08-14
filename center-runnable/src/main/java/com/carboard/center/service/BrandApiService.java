package com.carboard.center.service;

import com.carboard.center.exception.NoDataFoundException;
import com.carboard.domain.brand.Brand;
import com.carboard.domain.brand.BrandDto;
import com.carboard.domain.brand.BrandMapper;
import com.carboard.domain.brand.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BrandApiService {
    private final BrandRepository brandRepository;

    public BrandDto getBrand(Long brandId) {
        Optional<Brand> findBrandOp = brandRepository.findById(brandId);
        Brand findBrand = findBrandOp.orElseThrow(() -> { throw new NoDataFoundException(brandId); } );
        return BrandMapper.INSTANCE.toDto(findBrand);
    }

    public List<BrandDto> getBrands() {
        List<Brand> findBrands = brandRepository.findAll();
        return findBrands.stream().map(e -> BrandMapper.INSTANCE.toDto(e)).collect(Collectors.toList());
    }

    @Transactional
    public BrandDto createBrand(String name) {
        Brand saved = brandRepository.save(new Brand(name));
        return BrandMapper.INSTANCE.toDto(saved);
    }

    @Transactional
    public BrandDto updateBrand(Long brandId, String name) {
        Optional<Brand> findBrandOp = brandRepository.findById(brandId);
        Brand findBrand = findBrandOp.orElseGet(() -> { throw new NoDataFoundException(brandId); });
        findBrand.update(name);
        return BrandMapper.INSTANCE.toDto(findBrand);
    }
}
