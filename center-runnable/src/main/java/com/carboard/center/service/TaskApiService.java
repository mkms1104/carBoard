package com.carboard.center.service;

import com.carboard.domain.carMaster.CarMaster;
import com.carboard.domain.carMaster.CarMasterRepository;
import com.carboard.domain.task.Task;
import com.carboard.domain.task.TaskDto;
import com.carboard.domain.task.TaskMapper;
import com.carboard.domain.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class TaskApiService {
    private final TaskRepository taskRepository;
    private final CarMasterRepository carMasterRepository;

    public TaskDto toDto(Task task) {
        return TaskMapper.INSTANCE.toDto(task);
    }
    public Task toEntity(TaskDto taskDto) {
        return TaskMapper.INSTANCE.toEntity(taskDto);
    }

    public List<TaskDto> toDtoList(List<Task> tasks) {
        return tasks.stream()
                .map(v -> TaskMapper.INSTANCE.toDto(v))
                .collect(Collectors.toList());
    }

    @Transactional
    public TaskDto  update(Long taskId, TaskDto taskDto) {
        Optional<Task> taskOp = taskRepository.findById(taskId);
        Task task = taskOp.orElseThrow(() -> { throw new IllegalArgumentException("id is null"); });

        // Update
        Optional<CarMaster> carMasterOp = carMasterRepository.findById(1L);
        CarMaster carMaster = carMasterOp.orElseThrow(() -> {
            throw new IllegalArgumentException("ddd");
        });

        task.update(taskDto, carMaster);
        return TaskMapper.INSTANCE.toDto(task);
    }
}
