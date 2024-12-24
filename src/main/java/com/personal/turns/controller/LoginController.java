package com.personal.turns.controller;

import com.personal.turns.DTO.UserLoginDto;
import com.personal.turns.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDto) {
        return service.login(userLoginDto);
    }
}
