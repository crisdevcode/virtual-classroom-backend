package com.virtual.classroom.controllers;

import com.virtual.classroom.entities.Role;
import com.virtual.classroom.entities.User;
import com.virtual.classroom.entities.UserRole;
import com.virtual.classroom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users/")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) throws  Exception {
        user.setProfile("default.png");

        // Encrypt password
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        // Roles Object
        Set<UserRole> userRoles = new HashSet<>();

        // Create Role
        Role role = new Role();
        role.setRoleId(2L);
        role.setName("NORMAL");

        // Create user with role
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        // Add user with role
        userRoles.add(userRole);

        // Store in database
        return userService.saveUser(user, userRoles);
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








