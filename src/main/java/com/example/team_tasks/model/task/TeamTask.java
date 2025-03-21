package com.example.team_tasks.model.task;

import com.example.team_tasks.model.Categories;
import com.example.team_tasks.model.Priorities;
import com.example.team_tasks.model.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "TeamTask")
@Table(name = "TeamTask")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TeamTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Enumerated(EnumType.STRING)
    private Priorities priorities;
    @Enumerated(EnumType.STRING)
    private Categories categories;
}
