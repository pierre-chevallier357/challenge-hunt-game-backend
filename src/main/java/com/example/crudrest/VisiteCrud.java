package com.example.crudrest;

import com.example.entity.Visite;
import com.example.repository.VisiteRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/Visites")
public class VisiteCrud extends CrudRest<Visite, Integer, VisiteRepository> {
	public VisiteCrud(VisiteRepository repository) {
		super(repository);
	}
}
