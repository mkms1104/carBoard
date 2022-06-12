package com.carboard.domain.task;

import com.carboard.domain.car_master.CarMaster;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "task")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Task {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "task_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private TaskStatus status;

    private LocalDate deliveryDate;
    private String carModel;
    @ManyToOne
    @JoinColumn(name = "car_master_id")
    private CarMaster carMaster;

    private String customerName;
    private String customerPhone;
    private String carFront;
    private String carSideA;
    private String carSideB;
    private String carBack;
    private String panorama;
    private String blackBox;
    private String ppf;
    private String etc;
    private String coilMatt;
    private String glassFilm;
    private LocalDate releaseDate;
    @Column(unique = true)
    private String releaseImg;

    public void setCarMaster(CarMaster carMaster) {
        this.carMaster = carMaster;
    }
}
