package com.virtual.classroom.services.impl;

import com.virtual.classroom.entities.User;
import com.virtual.classroom.entities.UserRole;
import com.virtual.classroom.repository.RoleRepository;
import com.virtual.classroom.repository.UserRepository;
import com.virtual.classroom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User saveUser(User user, Set<UserRole> userRoles) throws Exception {
        User localUser = userRepository.findByUsername(user.getUsername());
        if(localUser != null) {
            System.out.println("User already exists");
            throw new Exception("User already exists");
        } else {
            for (UserRole userRole:userRoles) {
                roleRepository.save(userRole.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            localUser = userRepository.save((user));
        }

        return localUser;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}











