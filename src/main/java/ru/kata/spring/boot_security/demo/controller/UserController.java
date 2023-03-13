package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UsersService;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class UserController {

    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/user")
    public String showUser(Model model, Principal principal) {
        User user = usersService.getUserByEmail(principal.getName());
        model.addAttribute("user", usersService.getUserById(user.getId()));
        return "user";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login_page";
    }
}