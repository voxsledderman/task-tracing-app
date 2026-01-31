package com.example.task_tracer.domain.dto;

public record ErrorResponse(
        int status, String message, String details
) {
}
