package com.example.team_tasks.model.user;

import com.example.team_tasks.model.Priorities;
import jakarta.validation.constraints.NotNull;

public record PrioritiesDTO(@NotNull Priorities priorities) {
    public Priorities getPriorities() {
        return priorities;
    }

}
