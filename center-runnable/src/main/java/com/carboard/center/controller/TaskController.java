package com.carboard.center.controller;

import com.carboard.domain.task.Task;
import com.carboard.domain.task.TaskDto;
import com.carboard.domain.task.TaskMapper;
import com.carboard.domain.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/task")
public class TaskController {
    private final TaskRepository taskRepository;

    @GetMapping("test")
    public String testRoute(TaskDto taskDto) {
        System.out.println(taskDto);
        return "test";
    }

    @GetMapping
    public List<TaskDto> getTaskList() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
            .map(v -> TaskMapper.INSTANCE.toDto(v))
            .collect(Collectors.toList());
    }

    @PostMapping
    public String createTask(TaskDto taskForm) {


        return "";
    }
}