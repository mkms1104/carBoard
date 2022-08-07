package com.carboard.domain.task;

import com.carboard.domain.GenericMapper;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper extends GenericMapper<TaskDto, Task> {
}
