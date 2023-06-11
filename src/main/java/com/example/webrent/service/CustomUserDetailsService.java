package com.example.webrent.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {



    private BCryptPasswordEncoder passwordEncoder;

    public CustomUserDetailsService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Генерація рандомних значень для прикладу
        String randomUsername = "user123";
        String randomPassword = "pass123";
        long randomUserId = 1;

        // Закодувати введений пароль
        String encodedPassword = passwordEncoder.encode(randomPassword);

        if (!randomUsername.equals(username)) {
            throw new UsernameNotFoundException("Користувача з таким логіном не знайдено");
        }

        // Повернення UserDetails об'єкту з рандомними даними про користувача
        return new org.springframework.security.core.userdetails.User(
                randomUsername,
                encodedPassword,
                Collections.emptyList()
        );
    }
}
