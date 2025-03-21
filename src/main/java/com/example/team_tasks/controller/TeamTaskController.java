package com.example.team_tasks.controller;

import com.example.team_tasks.model.user.CategoriesDTO;
import com.example.team_tasks.model.task.TeamTask;
import com.example.team_tasks.model.user.PrioritiesDTO;
import com.example.team_tasks.model.user.UpdateTaskStatusDTO;
import com.example.team_tasks.service.TeamTaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/team-tasks")
public class TeamTaskController {

    private final TeamTaskService teamTaskService;
    public TeamTaskController(TeamTaskService teamTaskService) {
        this.teamTaskService = teamTaskService;
    }

    @PostMapping
    public TeamTask createTeamTask(@RequestBody TeamTask teamTask) {

        return teamTaskService.createTeamTask(teamTask);
    }

    @GetMapping
    public List<TeamTask> getAllTasks() {
        return teamTaskService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamTask> updateTeamTask(@PathVariable Long id, @RequestBody TeamTask teamTaskDetails) {
        TeamTask updatedTask = teamTaskService.updateTeamTask(id, teamTaskDetails);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeamTask(@PathVariable Long id) {
        Optional<TeamTask> taskDeleted = teamTaskService.getTeamTaskById(id);
        teamTaskService.deleteTeamTask(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<TeamTask> updateTaskStatus(@PathVariable Long id, @RequestBody @Valid UpdateTaskStatusDTO statusDTO) {
        TeamTask updatedStatus = teamTaskService.updateTaskStatus(id, statusDTO.getStatus());
        return ResponseEntity.ok(updatedStatus);

    }

    @PutMapping("/{id}/priorities")
    public ResponseEntity<TeamTask> setPriorities(@PathVariable Long id, @RequestBody @Valid PrioritiesDTO prioritiesDTO) {
        TeamTask priorities = teamTaskService.setPriorities(id, prioritiesDTO.getPriorities());
        return ResponseEntity.ok(priorities);
    }

    @PutMapping("/{id}/categories")
    public ResponseEntity<TeamTask> setCategories(@PathVariable Long id, @RequestBody @Valid CategoriesDTO categoriesDTO) {
        TeamTask categories = teamTaskService.setCategories(id, categoriesDTO.getCategories());
        return ResponseEntity.ok(categories);
    }

}
