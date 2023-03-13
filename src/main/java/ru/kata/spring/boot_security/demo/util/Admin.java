package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UsersService;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class Admin {

    private final RoleService roleService;
    private final UsersService usersService;

    @Autowired
    public Admin(RoleService roleService, UsersService usersService) {
        this.roleService = roleService;
        this.usersService = usersService;
    }

    @PostConstruct
    public void initialization() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        roleService.saveRole(roleAdmin);
        User admin = new User("admin", "admin", 34, "admin@gmail.com",
                "admin", Set.of(roleAdmin));
        usersService.saveUser(admin);

        Role roleUser = new Role("ROLE_USER");
        roleService.saveRole(roleUser);
        User user = new User("user", "user", 34, "user@gmail.com",
                "user", Set.of(roleUser));
        usersService.saveUser(user);

    }

}
