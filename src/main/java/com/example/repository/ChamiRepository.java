package com.example.repository;

import com.example.entity.Chami;
import org.springframework.data.repository.CrudRepository;

public interface ChamiRepository extends CrudRepository<Chami, String>, WithInsert<Chami> {
}
