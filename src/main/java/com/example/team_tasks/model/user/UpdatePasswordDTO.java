package com.example.team_tasks.model.user;

public record UpdatePasswordDTO(String login, String newPassword, String confirmPassword) {
}
