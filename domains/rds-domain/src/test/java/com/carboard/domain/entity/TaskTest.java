package com.carboard.domain.entity;

import com.carboard.domain.JpaTestSupport;
import com.carboard.domain.carMaster.CarMaster;
import com.carboard.domain.carMaster.CarMasterRepository;
import com.carboard.domain.task.Task;
import com.carboard.domain.task.TaskRepository;
import com.carboard.domain.task.TaskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest extends JpaTestSupport {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    CarMasterRepository carMasterRepository;

    @BeforeEach
    public void init() {
        CarMaster carMaster01 = carMasterRepository.save(new CarMaster("mskim11", "01011112222", "11h11m"));
        CarMaster carMaster02 = carMasterRepository.save(new CarMaster("mskim22", "01011112222", "11h11m"));
        CarMaster carMaster03 = carMasterRepository.save(new CarMaster("mskim33", "01011112222", "11h11m"));

        taskRepository.save(
            Task.builder()
                .status(TaskStatus.TASK_COMPLETED)
                .carMaster(carMaster01)
                .carModel("carnibal")
                .carFront("front1")
                .build()
        );

        taskRepository.save(
            Task.builder()
                .status(TaskStatus.TASK_COMPLETED)
                .carMaster(carMaster02)
                .carModel("carnibal")
                .carFront("front2")
                .build()
        );

        taskRepository.save(
            Task.builder()
                .status(TaskStatus.TASK_COMPLETED)
                .carMaster(carMaster03)
                .carModel("carnibal")
                .carFront("front3")
                .build()
        );
    }

    @Override
    protected void mapper() {

    }

    @Override
    @Test
    protected void jpaRepository() {
        List<Task> tasks = taskRepository.findAll();
        assertEquals(3, tasks.size());
    }

    @Override
    @Test
    protected void querydsl() {

    }
}
