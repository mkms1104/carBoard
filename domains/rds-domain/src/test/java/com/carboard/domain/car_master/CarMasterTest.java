package com.carboard.domain.car_master;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class CarMasterTest {

    @Autowired
    private CarMasterRepository carMasterRepository;

    @Test
    @DisplayName("save 테스트")
    public void save() {
        CarMasterMapper mapper = Mappers.getMapper(CarMasterMapper.class);
        CarMaster carMaster = mapper.toEntity(new CarMasterDto("mskim", "01065509952", "11h11m"));
        carMasterRepository.save(carMaster);

        Optional<CarMaster> carMasterOp = carMasterRepository.findByName("mskim");
        assertNotNull(carMasterOp.get());
        assertEquals("mskim", carMasterOp.get().getName());
        assertEquals("01065509952", carMasterOp.get().getPhone());
        assertEquals("11h11m", carMasterOp.get().getCompany());
    }
}