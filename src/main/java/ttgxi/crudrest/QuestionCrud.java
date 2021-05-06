package ttgxi.crudrest;

import ttgxi.entity.Question;
import ttgxi.repository.QuestionRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/questions")
public class QuestionCrud extends CrudRest<Question, Integer, QuestionRepository> {
	public QuestionCrud(QuestionRepository repository) {
		super(repository);
	}
}
