package com.carboard.center.api;

import com.carboard.domain.task.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/task")
public class TaskApiController {
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
    public String createTask(@RequestBody TaskDto newTask) {
        log.info("taskForm: {}", newTask);
        Task newTaskEntity = TaskMapper.INSTANCE.toEntity(newTask);
        taskRepository.save(newTaskEntity);
        return "ok";
    }

    @GetMapping("/{id}")
    public TaskDto getTaskByKeyword(@PathVariable("id") Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) return null;
        return TaskMapper.INSTANCE.toDto(optionalTask.get());
    }
}