package com.example.repository;

import com.example.entity.Arret;
import org.springframework.data.repository.CrudRepository;

public interface ArretRepository extends CrudRepository<Arret, Integer>, WithInsert<Arret> {
}
