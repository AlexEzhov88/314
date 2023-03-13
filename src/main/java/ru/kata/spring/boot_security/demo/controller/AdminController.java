package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UsersService;
import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UsersService usersService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UsersService usersService, RoleService roleService) {
        this.usersService = usersService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String getAdminPage(Principal principal, Model model) {
        model.addAttribute("user", usersService.getAllUsers());
        model.addAttribute("admin", usersService.getUserByEmail(principal.getName()));
        model.addAttribute("newUser", new User());
        model.addAttribute("rolesAdd", roleService.getAllRoles());
        return "admin";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
        usersService.saveUser(user);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        usersService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String removeUserById(@PathVariable("id") Integer id) {
        usersService.removeUserById(id);
        return "redirect:/admin";
    }

}