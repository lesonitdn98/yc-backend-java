package me.leson;

import me.leson.model.Role;
import me.leson.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initRole(RoleRepository repository) {
        return (args) -> {
            // save a few role
            if (repository.findAllByIdNotNull().size() == 0) {
                repository.save(new Role("admin"));
                repository.save(new Role("user"));
            }
        };
    }
}
