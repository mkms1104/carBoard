package com.carboard.center.car_master;

import com.carboard.domain.car_master.CarMaster;
import com.carboard.domain.car_master.CarMasterDto;
import com.carboard.domain.car_master.CarMasterMapper;
import com.carboard.domain.car_master.CarMasterRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class CarMasterTest {

    @Autowired
    private CarMasterRepository carMasterRepository;

    @Test
    @Rollback(false)
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