package com.virtual.classroom;

import com.virtual.classroom.entities.Role;
import com.virtual.classroom.entities.User;
import com.virtual.classroom.entities.UserRole;
import com.virtual.classroom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class VirtualClassroomBackendApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(VirtualClassroomBackendApplication.class, args);
	}


	// TEST
	@Override
	public void run(String... args) throws Exception {

		// New User
		/*
		User newUser = new User();

		newUser.setName("Cristian");
		newUser.setLastname("Unigarro");
		newUser.setUsername("crisdev");
		newUser.setPassword("123456");
		newUser.setEmail("crisdev@gmail.com");
		newUser.setPhone("3161245523");
		newUser.setProfile("avatar.jpg");

		// New Role
		Role newRole = new Role();
		newRole.setRoleId(1L);
		newRole.setName("Admin");

		// Relationship in the table userRoles
		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole();

		userRole.setRole(newRole);
		userRole.setUser(newUser);
		userRoles.add(userRole);

		// Save in Database
		User savedUser = userService.saveUser(newUser, userRoles);

		// Verify
		System.out.println(savedUser.getUsername());

		 */
	}
}
