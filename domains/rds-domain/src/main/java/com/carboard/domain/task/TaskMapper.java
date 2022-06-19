package com.carboard.domain.task;

import com.carboard.domain.entityUtil.GenericMapper;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper extends GenericMapper<TaskDto, Task> {
}
