package com.example.repository;

import com.example.entity.Visite;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VisiteRepository extends CrudRepository<Visite, Integer>, WithInsert<Visite> {
	List<Visite> findByUid(String uid);
	List<Visite> findByIdDefi(int idDefi);
}
