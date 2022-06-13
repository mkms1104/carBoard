package com.carboard.domain.car_master;

import com.carboard.domain.common.BaseTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarMaster extends BaseTime {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "car_master_id")
    private Long id;
    private String name;
    private String phone;
    private String company;
}
