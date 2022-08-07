package com.carboard.domain.task;

import lombok.Getter;

@Getter
public enum TaskStatus {
    BEFORE_RECEIVING("입고전"),
    BEFORE_TASK("작업전"),
    TODAY_TASK("금일작업"),
    TASK_COMPLETED("작업완료"),
    WRITE_COMPLETED("기재완료");

    private String desc;
    TaskStatus(String desc) {
        this.desc = desc;
    }
}
