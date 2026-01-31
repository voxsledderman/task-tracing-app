package com.example.task_tracer.mappers.impl;

import com.example.task_tracer.domain.dto.TaskDto;
import com.example.task_tracer.domain.entities.Task;
import com.example.task_tracer.mappers.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromDto(TaskDto taskDto) {
        return new Task(taskDto.id(), taskDto.title(),
                taskDto.dueDate(), taskDto.description(),
                taskDto.status(), taskDto.priority(),
                null, null, null

        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(task.getId(), task.getTitle(),
                task.getDescription(), task.getPriority(),
                task.getStatus(),null, null, null);
    }
}
