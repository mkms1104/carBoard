package com.carboard.domain.task;

import lombok.*;

import java.time.LocalDate;

@Getter @ToString
@Builder
public class TaskDto {
    private TaskStatus status;
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
    private String releaseImg;
}
