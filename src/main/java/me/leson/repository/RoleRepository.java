package me.leson.repository;

import me.leson.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findById(int id);

    List<Role> findAllByIdNotNull();
}
