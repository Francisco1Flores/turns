package com.personal.turns.service;

import com.personal.turns.DTO.UserRegistDto;
import com.personal.turns.model.User;
import com.personal.turns.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
public class SignUpService implements SignUp {

    private final UserRepository userRepository;
    private final PasswordService passwordService;

    @Autowired
    public SignUpService(
            UserRepository userRepository,
            PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    @Override
    public ResponseEntity<?> signUp(UserRegistDto userRegistDto) {
        Optional<User> existingUser = userRepository.findByUserNameOrEmail(
                userRegistDto.userName(),
                userRegistDto.email());
        if (existingUser.isPresent()) {
            if (existingUser.get().getUserName().equals(userRegistDto.userName())) {
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body(Map.of("Message", "User name already exists"));
            } else {
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body(Map.of("Message", "Email already exists"));
            }
        }

        //TODO validar los datos del dto de usuario


        User newUser =  new User();
        newUser.setUserName(userRegistDto.userName());
        newUser.setEmail(userRegistDto.email());
        newUser.setPassword(passwordService.securePassword(userRegistDto.password()));
        newUser.setName(userRegistDto.name());
        newUser.setLastName(userRegistDto.lastName());
        newUser.setCreationDate(LocalDateTime.now());
        newUser.setDeletionDate(null);
        User createdUser = userRepository.save(newUser);
        createdUser.setPassword("*******");

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newUser);
    }
}
