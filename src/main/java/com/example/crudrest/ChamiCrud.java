package com.example.crudrest;

import com.example.entity.Chami;
import com.example.entity.Defi;
import com.example.repository.ChamiRepository;
import com.example.repository.DefiRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/chamis")
public class ChamiCrud extends CrudRest<Chami, Integer, ChamiRepository> {
	private final DefiRepository defiRepository;

	public ChamiCrud(ChamiRepository repository, DefiRepository defiRepository) {
		super(repository);
		this.defiRepository = defiRepository;
	}

	@GetMapping("/{id}/defis")
	public List<Defi> readDefis(@PathVariable(value = "id") final int id) {
		return defiRepository.findByUid(id);
	}
}
