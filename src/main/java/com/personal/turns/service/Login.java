package com.personal.turns.service;

import com.personal.turns.DTO.UserLoginDto;
import org.springframework.http.ResponseEntity;

public interface Login {
    ResponseEntity<?> login(UserLoginDto userLoginDto);
}
