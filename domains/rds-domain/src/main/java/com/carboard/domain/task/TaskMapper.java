package com.carboard.domain.task;

import com.carboard.domain.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper extends GenericMapper<TaskDto, Task> {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);
}