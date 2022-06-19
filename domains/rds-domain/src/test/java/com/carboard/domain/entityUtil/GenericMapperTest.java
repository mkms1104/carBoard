package com.carboard.domain.entityUtil;

import com.carboard.domain.car_master.CarMaster;
import com.carboard.domain.car_master.CarMasterDto;
import com.carboard.domain.car_master.CarMasterMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 1. 매퍼 인터페이스 작성
 * 2. entity, dto 클래스에 allArgument 생성자 추가
 *   - entity 클래스는 접근 제어자 Protected
 *   - dto 클래스는 접근 제어자 Public 생성자 추가
 * 3. 매퍼 인스턴스 생성해서 사용
 * */
class GenericMapperTest {
    private CarMasterMapper carMasterMapper = Mappers.getMapper(CarMasterMapper.class);

    @Test
    @DisplayName("dto -> entity 매핑 확인")
    public void toEntity() {
        CarMasterDto dto = new CarMasterDto("mskim", "0106550992", "11h11m");
        CarMaster entity = carMasterMapper.toEntity(dto);
        System.out.println(entity);
    }

    @Test
    @DisplayName("entity -> dto 매핑 확인")
    public void toDto() {
        CarMaster entity = carMasterMapper.toEntity(new CarMasterDto("mskim", "0106550992", "11h11m"));

        CarMasterDto dto = carMasterMapper.toDto(entity);
        assertEquals(entity.getName(), dto.getName());
        assertEquals(entity.getPhone(), dto.getPhone());
        assertEquals(entity.getCompany(), dto.getCompany());
    }
}