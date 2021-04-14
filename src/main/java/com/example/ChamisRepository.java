package com.example;

import org.springframework.data.repository.CrudRepository;

public interface ChamisRepository extends CrudRepository<Chamis, String>, WithInsert<Chamis> {
}
