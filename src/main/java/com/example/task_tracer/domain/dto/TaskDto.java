package com.example.task_tracer.domain.dto;

import com.example.task_tracer.domain.entities.TaskPriority;
import com.example.task_tracer.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        TaskPriority priority,
        TaskStatus status,
        LocalDateTime dueDate,
        LocalDateTime created,
        LocalDateTime updated
) {
}
