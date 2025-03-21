package com.example.team_tasks.model.task;

import com.example.team_tasks.model.Categories;
import jakarta.validation.constraints.NotNull;

public record CategoriesDTO(@NotNull Categories categories) {
    public Categories getCategories() {
        return categories;
    }
}
