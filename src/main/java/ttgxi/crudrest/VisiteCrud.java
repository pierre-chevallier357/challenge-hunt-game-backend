package ttgxi.crudrest;

import ttgxi.entity.Visite;
import ttgxi.repository.VisiteRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/visites")
public class VisiteCrud extends CrudRest<Visite, Integer, VisiteRepository> {
	public VisiteCrud(VisiteRepository repository) {
		super(repository);
	}
}
