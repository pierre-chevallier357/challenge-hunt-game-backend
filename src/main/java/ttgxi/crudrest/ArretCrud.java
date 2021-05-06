package ttgxi.crudrest;

import ttgxi.entity.Arret;
import ttgxi.entity.Defi;
import ttgxi.repository.ArretRepository;
import ttgxi.repository.DefiRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/arrets")
public class ArretCrud extends CrudRest<Arret, Integer, ArretRepository> {
	private final DefiRepository defiRepository;

	public ArretCrud(ArretRepository repository, DefiRepository defiRepository) {
		super(repository);
		this.defiRepository = defiRepository;
	}

	@GetMapping("/code/{code}")
	public Arret readByCode(@PathVariable(value = "code") final String code) {
		return repository.findByCode(code).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/{id}/defis")
	public List<Defi> readDefis(@PathVariable(value = "id") final int id) {
		return defiRepository.findByIdArret(id);
	}
}
