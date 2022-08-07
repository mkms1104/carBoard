package com.carboard.center.controller;

import com.carboard.domain.task.TaskDto;
import com.carboard.domain.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("task")
public class TaskController {
    private final TaskRepository taskRepository;

    @GetMapping("test")
    public String testRoute(TaskDto taskDto) {
        System.out.println(taskDto);
        return "test";
    }


}
