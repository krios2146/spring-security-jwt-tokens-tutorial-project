package com.example.jwt_tokens;

import com.example.jwt_tokens.appuser.AppUser;
import com.example.jwt_tokens.appuser.AppUserService;
import com.example.jwt_tokens.role.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	CommandLineRunner run (AppUserService userService) {
		return args -> {
			userService.saveUser(new AppUser(null, "Danil Baschun", "db", "qwerty", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Max Ananin", "ma", "qwerty", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Aleksei Visotskih", "av", "qwerty", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Ulyana Taran", "ut", "qwerty", new ArrayList<>()));

			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MODERATOR"));
			userService.saveRole(new Role(null, "ROLE_SUPER_MODERATOR"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));


			userService.addRoleToUser("db", "ROLE_USER");
			userService.addRoleToUser("ma", "ROLE_MODERATOR");
			userService.addRoleToUser("av", "ROLE_SUPER_MODERATOR");
			userService.addRoleToUser("ut", "ROLE_ADMIN");

			userService.addRoleToUser("ut", "ROLE_SUPER_MODERATOR");
			userService.addRoleToUser("ut", "ROLE_MODERATOR");
			userService.addRoleToUser("ut", "ROLE_USER");
		};
	}

}
