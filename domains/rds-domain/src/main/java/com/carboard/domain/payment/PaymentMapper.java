package com.carboard.domain.payment;

import com.carboard.domain.GenericMapper;
import com.carboard.domain.product.ProductMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper extends GenericMapper<PaymentDto, Payment> {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
}
