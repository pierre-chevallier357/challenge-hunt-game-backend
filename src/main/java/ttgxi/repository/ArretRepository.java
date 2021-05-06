package ttgxi.repository;

import ttgxi.entity.Arret;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ArretRepository extends CrudRepository<Arret, Integer>, WithInsert<Arret> {
	Optional<Arret> findByCode(String code);
}
