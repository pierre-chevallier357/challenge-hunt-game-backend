package com.example.crudrest;

import com.example.entity.Chami;
import com.example.repository.ChamiRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/chamis")
public class ChamiCrud extends CrudRest<Chami, Integer, ChamiRepository> {
	public ChamiCrud(ChamiRepository repository) {
		super(repository);
	}
}
