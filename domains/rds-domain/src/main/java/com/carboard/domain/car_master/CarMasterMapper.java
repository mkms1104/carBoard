package com.carboard.domain.car_master;

import com.carboard.domain.entityUtil.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMasterMapper extends GenericMapper<CarMasterDto, CarMaster> {
}
