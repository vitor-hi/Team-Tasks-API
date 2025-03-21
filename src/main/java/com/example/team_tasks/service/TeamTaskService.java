package com.example.team_tasks.service;

import com.example.team_tasks.exception.ResourceNotFoundException;
import com.example.team_tasks.model.Categories;
import com.example.team_tasks.model.Priorities;
import com.example.team_tasks.model.TaskStatus;
import com.example.team_tasks.model.task.TeamTask;
import com.example.team_tasks.model.user.UpdateTaskStatusDTO;
import com.example.team_tasks.repository.TeamTaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TeamTaskService {

    private final TeamTaskRepository teamTaskRepository;
    public TeamTaskService(TeamTaskRepository teamTaskRepository) {
        this.teamTaskRepository = teamTaskRepository;
    }

    public TeamTask createTeamTask(TeamTask teamTask) {
        return teamTaskRepository.save(teamTask);
    }

    public List<TeamTask> getAll() {
        return teamTaskRepository.findAll();
    }

    public Optional<TeamTask> getTeamTaskById(Long id) {
        return teamTaskRepository.findById(id);
    }

    public TeamTask updateTeamTask(Long id, TeamTask taskDetails) {
       TeamTask teamTask = teamTaskRepository.findById(id).orElseThrow(() -> new RuntimeException("TeamTask not found for id: " + id));
       teamTask.setTitle(taskDetails.getTitle());
       teamTask.setDescription(taskDetails.getDescription());


       return teamTaskRepository.save(teamTask);
    }
    public void deleteTeamTask(Long id) {
        TeamTask teamTask = teamTaskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TeamTask not found!"));
        teamTaskRepository.delete(teamTask);
    }

    public TeamTask updateTaskStatus(Long id, TaskStatus status) {
        TeamTask teamTask = teamTaskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TeamTask not found!"));
        teamTask.setStatus(status);
        return teamTaskRepository.save(teamTask);
    }

    public TeamTask setPriorities(Long id, Priorities priorities) {
        TeamTask teamTask = teamTaskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TeamTask not found!"));
        teamTask.setPriorities(priorities);
        return teamTaskRepository.save(teamTask);
    }

    public TeamTask setCategories(Long id, Categories categories) {
        TeamTask teamTask = teamTaskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TeamTask not found!"));
        teamTask.setCategories(categories);
        return teamTaskRepository.save(teamTask);
    }


}