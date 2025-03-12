package com.example.team_tasks.service;

import com.example.team_tasks.model.task.TeamTask;
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
       teamTask.setCompleted(taskDetails.isCompleted());

       return teamTaskRepository.save(teamTask);
    }
    public void deleteTeamTask(Long id) {
        Optional teamTask = teamTaskRepository.findById(id);
        if(teamTask.isEmpty()){
            new RuntimeException ("TeamTask not found for id: " + id);
        }else {
            teamTaskRepository.deleteById(id);
        }
    }
}