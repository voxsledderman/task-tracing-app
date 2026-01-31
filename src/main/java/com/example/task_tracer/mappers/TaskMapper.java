package com.example.task_tracer.mappers;

import com.example.task_tracer.domain.dto.TaskDto;
import com.example.task_tracer.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);
    TaskDto toDto(Task task);
}
