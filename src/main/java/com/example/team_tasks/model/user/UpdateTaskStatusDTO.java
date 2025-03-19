package com.example.team_tasks.model.user;

import com.example.team_tasks.model.TaskStatus;

import jakarta.validation.constraints.NotNull;

public record UpdateTaskStatusDTO(@NotNull TaskStatus status) {
    public TaskStatus getStatus() {
        return status;
    }

}
