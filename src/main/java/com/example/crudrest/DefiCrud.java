package com.example.crudrest;

import com.example.entity.Defi;
import com.example.repository.DefiRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.repository.VisiteRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/defis")
public class DefiCrud extends CrudRest<Defi, String, DefiRepository> {
	private final VisiteRepository visiteRepository;

	public DefiCrud(DefiRepository repository, VisiteRepository visiteRepository) {
		super(repository);
		this.visiteRepository = visiteRepository;
	}

	@GetMapping("/{idDefi}/visites")
	public List<Visite> readVisites(@PathVariable(value = "idDefi") final String idDefi) {
		return visiteRepository.findByIdDefi(idDefi);
	}
}
