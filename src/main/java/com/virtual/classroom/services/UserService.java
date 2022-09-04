package com.virtual.classroom.services;

import com.virtual.classroom.entities.User;
import com.virtual.classroom.entities.UserRole;

import java.util.Set;

public interface UserService {
    public User saveUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUser(String username);

    public void deleteUser(Long userId);
}
