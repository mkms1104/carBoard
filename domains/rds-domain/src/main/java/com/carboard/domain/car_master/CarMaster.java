package com.carboard.domain.car_master;

import com.carboard.domain.metaEntity.BaseTime;
import com.carboard.domain.task.Task;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
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

    @OneToMany(mappedBy = "carMaster")
    private List<Task> tasks = List.of();
}
