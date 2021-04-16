package com.example.repository;

import com.example.entity.Visite;
import org.springframework.data.repository.CrudRepository;

public interface VisiteRepository extends CrudRepository<Visite, Integer>, WithInsert<Visite> {
}
