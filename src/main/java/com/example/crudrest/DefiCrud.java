package com.example.crudrest;

import com.example.entity.Defi;
import com.example.repository.DefiRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/defis")
public class DefiCrud extends CrudRest<Defi, String, DefiRepository> {
	public DefiCrud(DefiRepository repository) {
		super(repository);
	}
}
