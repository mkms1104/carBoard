package com.carboard.domain.carMaster;

import com.carboard.domain.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMasterMapper extends GenericMapper<CarMasterDto, CarMaster> {
    CarMasterMapper INSTANCE = Mappers.getMapper(CarMasterMapper.class);
}
