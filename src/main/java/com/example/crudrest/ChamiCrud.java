package com.example.crudrest;

import com.example.entity.Chami;
import com.example.entity.Defi;
import com.example.entity.Visite;
import com.example.repository.ChamiRepository;
import com.example.repository.DefiRepository;
import com.example.repository.VisiteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/chamis")
public class ChamiCrud extends CrudRest<Chami, String, ChamiRepository> {
	private final DefiRepository defiRepository;
	private final VisiteRepository visiteRepository;

	public ChamiCrud(ChamiRepository repository, DefiRepository defiRepository, VisiteRepository visiteRepository) {
		super(repository);
		this.defiRepository = defiRepository;
		this.visiteRepository = visiteRepository;
	}

	@GetMapping("/{id}/defis")
	public List<Defi> readDefis(@PathVariable(value = "id") final String id) {
		return defiRepository.findByUid(id);
	}

	@GetMapping("/{id}/visites")
	public List<Visite> readVisites(@PathVariable(value = "id") final String id) {
		return visiteRepository.findByUid(id);
	}
}
