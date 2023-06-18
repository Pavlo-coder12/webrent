package com.example.webrent.controllers;

import com.example.webrent.repositories.UserConnection;
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

import java.sql.SQLException;

@Controller
@RequestMapping("/")
public class AdversController {

    @GetMapping("/")
    public String aut() {
        return "listAdvers";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/password")
    public String deletePassword() {
        return "password";
    }

    @GetMapping("/code")
    public String code() {
        return "code";
    }

    @GetMapping("/sellerForm/listAdversS")
    public String sellerAdvers() {
        return "sellerForm/listAdversS";
    }

    @GetMapping("/sellerForm/registrationAdver")
    public String sellerReg() {
        return "/sellerForm/registrationAdver";
    }

    @GetMapping("/sellerForm/subscriptionForm")
    public String sellerSub() {
        return "sellerForm/subscriptionForm";
    }

    @GetMapping("/sellerForm/sellerFormB")
    public String sellerB() {
        return "sellerForm/sellerFormB";
    }

    @GetMapping("/customerForm/listAdversC")
    public String customerAdvers() {
        return "customerForm/listAdversC";
    }

    @GetMapping("/customerForm/customerFormB")
    public String customerFormB() {
        return "customerForm/customerFormB";
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
        return "authentication";
    }

    @GetMapping("/main")
    public String method() {
        // Ваш код тут
        return "main";
    }

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/authentication/listAdvers")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) throws SQLException {
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
            String typeUser = UserConnection.getUserType((String) session.getAttribute("username"));
            // Перенаправлення на сторінку після успішної автентифікації
            if (typeUser.equals("seller")) {
                return "sellerForm/listAdversS";
            } else if (typeUser.equals("customer")) {
                return "customerForm/listAdversC";
            } else  {
                return "authentication";
            }

        } else {
            // Обробка некоректного логіна або пароля
            return "redirect:/login?error";
        }
    }

    @GetMapping("/authentication/code")
    public String checkCode() {
        // Ваш код тут
        return "code";
    }

    // Метод для перевірки коректності логіна та пароля
    private boolean isValidLogin(String username, String password) {
        // Ваш код перевірки логіна та пароля
        // Повертає true, якщо логін та пароль є коректними, інакше - false
        return true;
    }



}
