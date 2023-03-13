package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UsersService {

    public List<User> getAllUsers();
    public void saveUser(User user);
    public User getUserById(Integer id);
    public void updateUser(User user);
    public void removeUserById(Integer id);
    public User getUserByEmail(String email);

}
