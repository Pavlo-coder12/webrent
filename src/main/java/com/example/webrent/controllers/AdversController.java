package com.example.webrent.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

@Controller
@RequestMapping("/")
public class AdversController {

    @GetMapping("/")
    public String aut() {
        return "main";
    }

//    @GetMapping("/user")
//    public String goToUser(@RequestParam("name") String name,
//                           @RequestParam("surname") String surname,
//                           Model model) {
////        String fullName = name + surname;
//        model.addAttribute("name", name);
//        model.addAttribute("surname", surname);
//        return "user";
//    }

//    @PostMapping("/user")
//    public String goToUser(@RequestBody User human) {
////        String fullName = name + surname;
//        System.out.println(human.getName() + " " + human.getSurname() + "fd");
//        return "/user";
//    }

    @GetMapping("/aut")
    public String yourMethod() {
        // Ваш код тут
        return "aut";
    }

    @GetMapping("/main")
    public String method() {
        // Ваш код тут
        return "main";
    }

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        // Перевірка коректності логіна та пароля
        System.out.println("FUckkckc");
        if (isValidLogin(username, password)) {
            System.out.println("YEEEEEEESSSSS");
            // Створення автентифікаційного об'єкта
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
            System.out.println("Point 1");
            // Виклик AuthenticationManager для автентифікації
            Authentication authenticated = authenticationManager.authenticate(authentication);
            System.out.println("Point 2");
            // Встановлення автентифікованого користувача в SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authenticated);
            System.out.println("Point 3");
            // Створення сесії для користувача
            HttpSession session = request.getSession(true);
            System.out.println("Point 4");
            session.setAttribute("username", username);
            System.out.println("Point 5");
            // Перенаправлення на сторінку після успішної автентифікації
            return "/user";
        } else {
            // Обробка некоректного логіна або пароля
            return "redirect:/login?error";
        }
    }

    // Метод для перевірки коректності логіна та пароля
    private boolean isValidLogin(String username, String password) {
        // Ваш код перевірки логіна та пароля
        // Повертає true, якщо логін та пароль є коректними, інакше - false
        return true;
    }



}
