package com.example.crudrest;

import com.example.entity.Question;
import com.example.repository.QuestionRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/Questions")
public class QuestionCrud extends CrudRest<Question, Integer, QuestionRepository> {
	public QuestionCrud(QuestionRepository repository) {
		super(repository);
	}
}
