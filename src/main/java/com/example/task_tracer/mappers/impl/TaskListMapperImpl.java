package com.example.task_tracer.mappers.impl;

import com.example.task_tracer.domain.dto.TaskListDto;
import com.example.task_tracer.domain.entities.Task;
import com.example.task_tracer.domain.entities.TaskList;
import com.example.task_tracer.domain.entities.TaskStatus;
import com.example.task_tracer.mappers.TaskListMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapperImpl taskMapper;

    public TaskListMapperImpl(TaskMapperImpl taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        return new TaskListDto(taskList.getId(), taskList.getTitle(),
                taskList.getDescription(), Optional.ofNullable(taskList.getTasks())
                .map(List::size)
                .orElse(0), calculateProgress(taskList.getTasks()), Optional.ofNullable(taskList.getTasks())
                .map(
                        tasks -> tasks.stream().
                                map(taskMapper::toDto).toList()
                ).orElse(null)
        );
    }

    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return new TaskList(taskListDto.id(), taskListDto.title(),
                taskListDto.description(), Optional.ofNullable(taskListDto.tasks())
                .map(tasks -> tasks.stream()
                        .map(taskMapper::fromDto).toList()
                ).orElse(null), null, null
        );
    }

    private Double calculateProgress(List<Task> tasks){

        if(tasks == null || tasks.isEmpty()) return null;
        long closed = tasks.stream()
                .filter(task -> task.getStatus().equals(TaskStatus.CLOSED)).count();


        return closed / (double) tasks.size();
    }
}
