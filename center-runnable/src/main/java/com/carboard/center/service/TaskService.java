package com.carboard.center.service;

import com.carboard.domain.task.Task;
import com.carboard.domain.task.TaskDto;
import com.carboard.domain.task.TaskMapper;
import com.carboard.domain.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskService {
    private final TaskRepository taskRepository;

    @Transactional
    public TaskDto  update(Long id, TaskDto taskDto) {
        Optional<Task> taskOp = taskRepository.findById(id);
        Task task = taskOp.orElseThrow(() -> { throw new IllegalArgumentException("id is null"); });
        task.update(taskDto);

        return TaskMapper.INSTANCE.toDto(task);
    }
}
