package com.carboard.center.controller;

import com.carboard.center.service.TaskService;
import com.carboard.domain.task.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class TaskController {
    private final TaskRepository taskRepository;
    private final TaskService taskService;

    @GetMapping("/api/v1/task")
    public List<TaskDto> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
            .map(v -> TaskMapper.INSTANCE.toDto(v))
            .collect(Collectors.toList());
    }

    @PostMapping("/api/v1/task")
    public ResponseEntity createTask(@RequestBody TaskDto newTask) {
        Task newTaskEntity = TaskMapper.INSTANCE.toEntity(newTask);
        taskRepository.save(newTaskEntity);
        return ResponseEntity.created(URI.create("")).build();
    }

    @GetMapping("/api/v1/task/{id}")
    public ResponseEntity getTask(@PathVariable("id") Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) return null;
        return ResponseEntity.ok(TaskMapper.INSTANCE.toDto(optionalTask.get()));
    }

    @PostMapping("/search")
    public List<TaskDto> getTasksByStatusAndKeyword(@RequestBody TaskDto taskDto) {
//        log.info("taskDto {}: ", taskDto);
//        List<Task> tasks = taskRepository.findAllByStatusAndKeyword();
//        return tasks.stream()
//            .map(v -> TaskMapper.INSTANCE.toDto(v))
//            .collect(Collectors.toList());
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTask(@PathVariable("id") Long id, @RequestBody TaskDto updateDto) {
        return ResponseEntity.ok(taskService.update(id, updateDto));
    }
}