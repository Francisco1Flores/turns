package com.personal.turns.service;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    public String securePassword(String password) {
        Argon2 argon2 = getArgon2Instance();
        return argon2.hash(1,65536,1,password.toCharArray());
    }

    private Argon2 getArgon2Instance() {
        return Argon2Factory.create();
    }
}
