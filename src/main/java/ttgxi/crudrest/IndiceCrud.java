package ttgxi.crudrest;

import ttgxi.entity.Indice;
import ttgxi.repository.IndiceRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/indices")
public class IndiceCrud extends CrudRest<Indice, Integer, IndiceRepository> {
	public IndiceCrud(IndiceRepository repository) {
		super(repository);
	}
}
