package com.personal.turns.service;

import com.personal.turns.DTO.UserLoginDto;
import com.personal.turns.model.User;
import com.personal.turns.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements Login {

    UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public ResponseEntity<?> login(UserLoginDto userLoginDto) {
        Optional<User> user = userRepository.findByUserNameOrEmail(
                userLoginDto.getIdentificator(),
                userLoginDto.getIdentificator());

        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User existingUser = user.get();

        if (!passwordsAreEquals(userLoginDto.getPassword(), existingUser.getPassword())) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    private boolean passwordsAreEquals(String actual, String saved) {
        Argon2PasswordEncoder encoder = new Argon2PasswordEncoder(16, 32,1, 1<<14,1);
        actual = encoder.encode(actual);
        return encoder.matches(actual, saved);
    }
}
