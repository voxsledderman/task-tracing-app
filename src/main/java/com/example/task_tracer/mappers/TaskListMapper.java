package com.example.task_tracer.mappers;

import com.example.task_tracer.domain.dto.TaskListDto;
import com.example.task_tracer.domain.entities.TaskList;

public interface TaskListMapper {

    TaskListDto toDto(TaskList taskList);
    TaskList fromDto(TaskListDto taskListDto);
}
