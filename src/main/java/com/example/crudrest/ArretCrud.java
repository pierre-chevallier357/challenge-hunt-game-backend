package com.example.crudrest;

import com.example.entity.Arret;
import com.example.repository.ArretRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
@RequestMapping("/api/arrets")
public class ArretCrud extends CrudRest<Arret, Integer, ArretRepository> {
	public ArretCrud(ArretRepository repository) {
		super(repository);
	}

	@GetMapping("/code/{code}")
	public Arret readByCode(@PathVariable(value = "code") final String code) {
		return repository.findByCode(code).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
