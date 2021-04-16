package com.example.repository;

import com.example.entity.Indice;
import org.springframework.data.repository.CrudRepository;

public interface IndiceRepository extends CrudRepository<Indice, Integer>, WithInsert<Indice> {
}
