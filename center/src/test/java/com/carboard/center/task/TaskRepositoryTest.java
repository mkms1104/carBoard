package com.carboard.center.task;

import com.carboard.domain.task.Task;
import com.carboard.domain.task.TaskDto;
import com.carboard.domain.task.TaskMapper;
import com.carboard.domain.task.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
public class TaskRepositoryTest {
    @Autowired
    private TaskRepository taskRepository;

    private TaskMapper taskMapper = Mappers.getMapper(TaskMapper.class);

    @DisplayName("Add Task")
    @Test
    void addTask() throws Exception {
        TaskDto taskDto = TaskDto.builder()
                .customerName("민수")
                .customerPhone("010-0000-0000")
                .build();

        Task entity = taskMapper.toEntity(taskDto);
        taskRepository.save(entity);
    }
}
