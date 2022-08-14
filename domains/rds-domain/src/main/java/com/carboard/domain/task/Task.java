package com.carboard.domain.task;

import com.carboard.domain.carMaster.CarMaster;
import com.carboard.domain.metaEntity.BaseTime;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private TaskStatus status;

    private LocalDate deliveryDate;
    private String carModel;
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

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_master_id")
    private CarMaster carMaster;

    public void update(TaskDto dto, CarMaster carMaster) {
        //Status
        this.status = dto.getStatus();
        this.deliveryDate = dto.getDeliveryDate();
        this.releaseDate = dto.getReleaseDate();
        this.releaseImg = dto.getReleaseImg();
        this.carMaster = carMaster;

        //Service
        this.carFront = dto.getCarFront();
        this.carSideA = dto.getCarSideA();
        this.carSideB = dto.getCarSideB();
        this.carBack = dto.getCarBack();
        this.panorama = dto.getPanorama();
        this.blackBox = dto.getBlackBox();
        this.ppf = dto.getPpf();
        this.etc = dto.getEtc();
        this.coilMatt = dto.getCoilMatt();
        this.glassFilm = dto.getGlassFilm();
    }
}
