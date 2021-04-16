package com.example.repository;

import com.example.entity.Defi;
import org.springframework.data.repository.CrudRepository;

public interface DefiRepository extends CrudRepository<Defi, String>, WithInsert<Defi> {
}
