package me.leson.repository;

import me.leson.model.Size;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SizeRepository extends CrudRepository<Size, Integer> {
    Size findById(int id);

    List<Size> findAllByIdNotNull();
}
