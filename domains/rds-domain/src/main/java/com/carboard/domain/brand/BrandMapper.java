package com.carboard.domain.brand;

import com.carboard.domain.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface BrandMapper extends GenericMapper<BrandDto, Brand> {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
}
