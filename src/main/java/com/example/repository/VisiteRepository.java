package com.example.repository;

import com.example.entity.Visite;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VisiteRepository extends CrudRepository<Visite, String>, WithInsert<Visite> {
	List<Visite> findByUid(int uid);
}
