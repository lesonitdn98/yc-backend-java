package me.leson;

import me.leson.model.Role;
import me.leson.model.Size;
import me.leson.model.Sugar;
import me.leson.repository.RoleRepository;
import me.leson.repository.SizeRepository;
import me.leson.repository.SugarRepository;
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
    public CommandLineRunner initData(RoleRepository roleRepository, SizeRepository sizeRepository, SugarRepository sugarRepository) {
        return (args) -> {
            // save a few role
            if (roleRepository.findAllByIdNotNull().size() == 0) {
                roleRepository.save(new Role("admin"));
                roleRepository.save(new Role("user"));
            }
            // save a few size
            if (sizeRepository.findAllByIdNotNull().size() == 0) {
                sizeRepository.save(new Size("Nhỏ"));
                sizeRepository.save(new Size("Vừa"));
                sizeRepository.save(new Size("Lớn"));
            }

            // save a few sugar
            if (sugarRepository.findAllByIdNotNull().size() == 0) {
                sugarRepository.save(new Sugar("Không đường"));
                sugarRepository.save(new Sugar("Sương sương"));
                sugarRepository.save(new Sugar("Vừa phải"));
                sugarRepository.save(new Sugar("Nhiều đường"));
            }
        };
    }
}
