package com.example;

import org.springframework.data.repository.CrudRepository;

public interface ChamiRepository extends CrudRepository<Chami, Integer>, WithInsert<Chami> {
}
