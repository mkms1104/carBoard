package com.carboard.domain.entity;

import com.carboard.domain.JpaTestSupport;
import com.carboard.domain.carMaster.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.carboard.domain.carMaster.QCarMaster.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarMasterTest extends JpaTestSupport {
    @Autowired CarMasterRepository carMasterRepository;

    @BeforeEach
    public void init() {
        CarMaster carMaster01 = new CarMaster("mskim", "0101112222", "11h11m");
        CarMaster carMaster02 = new CarMaster("tnsska2", "0101112222", "11h11m");
        CarMaster carMaster03 = new CarMaster("jeongi", "0101112222", "11h11m");
        carMasterRepository.save(carMaster01);
        carMasterRepository.save(carMaster02);
        carMasterRepository.save(carMaster03);
    }

    @Override
    @Test
    protected void mapper() {
        //given
        CarMasterDto dto = new CarMasterDto("mskim", "01011112222", "11h11m");
        CarMaster entity = new CarMaster("mskim2", "01011112222", "11h11m");

        //when
        CarMaster toEntity = CarMasterMapper.INSTANCE.toEntity(dto);
        CarMasterDto toDto = CarMasterMapper.INSTANCE.toDto(entity);

        //then
        assertEquals("mskim", toEntity.getName());
        assertEquals("mskim2", toDto.getName());
    }

    @Override
    @Test
    protected void jpaRepository() {
        List<CarMaster> findAll = carMasterRepository.findAll();
        assertEquals(3, findAll.size());
    }

    @Override
    @Test
    protected void querydsl() {
        List<CarMaster> result = factory.selectFrom(carMaster)
                .where(carMaster.company.eq("11h11m"))
                .fetch();

        assertEquals(3, result.size());
    }
}