package com.example.crudrest;

import com.example.entity.Arret;
import com.example.repository.ArretRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/arrets")
public class ArretCrud extends CrudRest<Arret, Integer, ArretRepository> {
	public ArretCrud(ArretRepository repository) {
		super(repository);
	}
}
