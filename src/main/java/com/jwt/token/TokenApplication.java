package com.jwt.token;

import com.jwt.token.model.AppUser;
import com.jwt.token.model.Role;
import com.jwt.token.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class TokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokenApplication.class, args);
	}

	@Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

	@Bean
	CommandLineRunner run(UserService userService)
	{
		return  args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser(null,"Veer", "veer","123", new ArrayList<>()));
			userService.saveUser(new AppUser(null,"Nikhil", "nikhil","123", new ArrayList<>()));
			userService.saveUser(new AppUser(null,"Pooja", "pooja","123", new ArrayList<>()));
			userService.saveUser(new AppUser(null,"Priya", "priya","123", new ArrayList<>()));

			userService.addRoleToUser("veer","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("nikhil","ROLE_ADMIN");
			userService.addRoleToUser("pooja","ROLE_MANAGER");
			userService.addRoleToUser("priya","ROLE_USER");
		};
	}

}
