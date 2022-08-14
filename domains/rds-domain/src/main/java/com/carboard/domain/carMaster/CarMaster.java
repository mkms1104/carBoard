package com.carboard.domain.carMaster;

import com.carboard.domain.metaEntity.BaseTime;
import com.carboard.domain.task.Task;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarMaster extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_master_id")
    private Long id;
    private String name;
    private String phone;
    private String company;

    @OneToMany(mappedBy = "carMaster")
    @ToString.Exclude
    private List<Task> task = new ArrayList<>();

    public CarMaster(String name, String phone, String company) {
        this.name = name;
        this.phone = phone;
        this.company = company;
    }
}
