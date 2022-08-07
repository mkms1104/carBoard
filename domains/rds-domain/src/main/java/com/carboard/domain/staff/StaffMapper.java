package com.carboard.domain.staff;

import com.carboard.domain.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface StaffMapper extends GenericMapper<StaffDto, Staff> {
    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);
}
