package com.carboard.domain.car_master;

import lombok.*;

@Getter @ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarMasterDto {
    private String name;
    private String phone;
    private String company;
}
