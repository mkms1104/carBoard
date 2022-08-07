package com.carboard.domain.product;

import com.carboard.domain.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper extends GenericMapper<ProductDto, Product> {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
}
