package com.example.repository;

import com.example.entity.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer>, WithInsert<Question> {
}
