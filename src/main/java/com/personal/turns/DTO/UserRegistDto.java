package com.personal.turns.DTO;

public record UserRegistDto(
        String userName,
        String email,
        String password,
        String name,
        String lastName
) { }
