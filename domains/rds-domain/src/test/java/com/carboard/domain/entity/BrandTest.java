package com.carboard.domain.entity;

import com.carboard.domain.JpaTestSupport;
import com.carboard.domain.brand.Brand;
import com.carboard.domain.brand.BrandDto;
import com.carboard.domain.brand.BrandMapper;
import com.carboard.domain.brand.BrandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.carboard.domain.brand.QBrand.brand;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BrandTest extends JpaTestSupport {
    @Autowired
    BrandRepository brandRepository;

    @BeforeEach
    public void init() {
        Brand brand01 = new Brand("brand01");
        Brand brand02 = new Brand("brand02");
        Brand brand03 = new Brand("brand03");
        brandRepository.save(brand01);
        brandRepository.save(brand02);
        brandRepository.save(brand03);
    }

    @Test
    @Override
    public void mapper() {
        //given
        BrandDto dto = new BrandDto("myBrand01");
        Brand entity = new Brand("myBrand02");

        //when
        Brand toEntity = BrandMapper.INSTANCE.toEntity(dto);
        BrandDto toDto = BrandMapper.INSTANCE.toDto(entity);

        //then
        assertEquals("myBrand01", toEntity.getName());
        assertEquals("myBrand02", toDto.getName());
    }

    @Test
    @Override
    public void jpaRepository() {
        //given
        List<Brand> findAll = brandRepository.findAll();

        //when

        //then
        assertEquals(3, findAll.size());
        assertEquals("brand01", findAll.get(0).getName());
        assertEquals("brand02", findAll.get(1).getName());
        assertEquals("brand03", findAll.get(2).getName());
    }

    @Test
    @Override
    public void querydsl() {
        //given
        Brand findBrand = factory.selectFrom(brand)
                .where(brand.name.eq("brand01"))
                .fetchOne();

        //then
        assertEquals("brand01", findBrand.getName());
    }
}