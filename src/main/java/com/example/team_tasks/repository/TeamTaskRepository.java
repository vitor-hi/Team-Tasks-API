package com.example.team_tasks.repository;

import com.example.team_tasks.model.task.TeamTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamTaskRepository extends JpaRepository<TeamTask, Long> {

}
