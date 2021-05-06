package ttgxi.repository;

import java.util.List;

import ttgxi.entity.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer>, WithInsert<Question> {
    List<Question> findByIdDefi(int idDefi);
}
