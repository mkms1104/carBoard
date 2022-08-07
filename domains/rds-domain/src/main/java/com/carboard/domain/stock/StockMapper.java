package com.carboard.domain.stock;

import com.carboard.domain.GenericMapper;
import com.carboard.domain.staff.StaffMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StockMapper extends GenericMapper<StockDto, Stock> {
    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);
}
