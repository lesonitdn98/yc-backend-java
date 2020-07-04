package me.leson.repository;

import me.leson.model.Sugar;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SugarRepository extends CrudRepository<Sugar, Integer> {
    Sugar findById(int id);

    List<Sugar> findAllByIdNotNull();
}
