package com.example.repository;

import com.example.entity.Defi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DefiRepository extends CrudRepository<Defi, String>, WithInsert<Defi> {
	public List<Defi> findByUid(int uid);
}
