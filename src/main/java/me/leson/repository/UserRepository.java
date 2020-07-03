package me.leson.repository;

import me.leson.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByAccount_Username(String username);
}
