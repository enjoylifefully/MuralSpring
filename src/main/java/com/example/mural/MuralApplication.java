package com.example.mural;

import com.example.mural.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MuralApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuralApplication.class, args);
	}

	@Bean
	CommandLineRunner seedUsers(UserRepository userRepository) {
		return args -> {
			if (userRepository.count() == 0) {
				userRepository.save("admin", "admin", "ADMIN");
				userRepository.save("user", "user", "USER");
			}
		};
	}
}
