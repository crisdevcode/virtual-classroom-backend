package com.virtual.classroom.controllers;

import com.virtual.classroom.entities.Role;
import com.virtual.classroom.entities.User;
import com.virtual.classroom.entities.UserRole;
import com.virtual.classroom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) throws  Exception {
        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(2L);
        role.setName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        System.out.println(user);
        return userService.saveUser(user, roles);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return userService.getUser(username);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }
}








