package com.personal.turns.controller;

import com.personal.turns.DTO.UserRegistDto;
import com.personal.turns.service.SignUp;
import com.personal.turns.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SignUpController {

    SignUp signUpService;

    @Autowired
    public SignUpController(SignUpService registerService) {
        this.signUpService = registerService;
    }

    @PostMapping("/users/signUp")
    public ResponseEntity<?> signUp(@RequestBody UserRegistDto userRegistDto) {
        return signUpService.signUp(userRegistDto);
    }

    @GetMapping("/users/signUp")
    public ResponseEntity<?> algo() {
        return ResponseEntity.status(200).body("hola gente como están?");
    }

}
