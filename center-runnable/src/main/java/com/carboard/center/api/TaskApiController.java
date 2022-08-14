package com.carboard.center.api;

import com.carboard.center.exception.NoDataFoundException;
import com.carboard.center.service.TaskApiService;
import com.carboard.domain.task.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("api/v1")
@RestController
public class TaskApiController {
    private final TaskRepository taskRepository;
    private final TaskApiService taskApiService;

    @GetMapping("tasks")
    public ResponseEntity getTasks(@RequestParam(required = false) TaskStatus status,
                                   @RequestParam(required = false) String keyword) {
        //TODO: 동적쿼리 만들어줘야 함.
        List<Task> tasks = taskRepository.findAllByStatus(status);
        return ResponseEntity.ok(taskApiService.toDtoList(tasks));
    }

    @GetMapping("tasks/{id}")
    public ResponseEntity getTask(@PathVariable("id") Long taskId) {
        Optional<Task> taskOp = taskRepository.findById(taskId);
        Task task = taskOp.orElseThrow(() -> { throw new NoDataFoundException(taskId); });
        return ResponseEntity.ok(taskApiService.toDto(task));
    }

    @PostMapping("tasks")
    public ResponseEntity createTask(@RequestBody TaskDto newTask) {
        Task newTaskEntity = taskApiService.toEntity(newTask);
        taskRepository.save(newTaskEntity);
        return ResponseEntity.created(URI.create("")).build();
    }

    @PutMapping("tasks/{id}")
    public ResponseEntity updateTask(@PathVariable("id") Long taskId, @RequestBody TaskDto updateDto) {
        return ResponseEntity.ok(taskApiService.update(taskId, updateDto));
    }

    @DeleteMapping("tasks/{id}")
    public ResponseEntity deleteTask(@PathVariable("id") Long taskId) {
        taskRepository.deleteById(taskId);
        return ResponseEntity.ok().build();
    }
}