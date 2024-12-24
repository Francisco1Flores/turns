package com.personal.turns.service;

import com.personal.turns.DTO.UserRegistDto;
import org.springframework.http.ResponseEntity;

public interface SignUp {
    ResponseEntity<?> signUp(UserRegistDto userRegistDto);
}
