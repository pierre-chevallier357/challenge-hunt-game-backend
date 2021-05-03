package com.example.crudrest;

import java.util.List;

import com.example.entity.Defi;
import com.example.entity.Question;
import com.example.entity.Visite;
import com.example.repository.DefiRepository;
import com.example.repository.QuestionRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.repository.VisiteRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/defis")
public class DefiCrud extends CrudRest<Defi, Integer, DefiRepository> {
	private final VisiteRepository visiteRepository;
	private QuestionRepository questionRepository;

	public DefiCrud(DefiRepository repository, VisiteRepository visiteRepository, QuestionRepository questionRepository) {
		super(repository);
		this.visiteRepository = visiteRepository;
		this.questionRepository = questionRepository;
	}

	@GetMapping("/{idDefi}/visites")
	public List<Visite> readVisites(@PathVariable(value = "idDefi") final int idDefi) {
		return visiteRepository.findByIdDefi(idDefi);
	}

	@GetMapping("/{idDefi}/questions")
	public List<Question> readQuestion(@PathVariable(value = "idDefi") final int idDefi) {
		return questionRepository.findByIdDefi(idDefi);
	}
}
