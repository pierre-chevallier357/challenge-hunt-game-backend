package ttgxi.repository;

import ttgxi.entity.Chami;
import org.springframework.data.repository.CrudRepository;

public interface ChamiRepository extends CrudRepository<Chami, String>, WithInsert<Chami> {
}
