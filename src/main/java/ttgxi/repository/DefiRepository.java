package ttgxi.repository;

import ttgxi.entity.Defi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DefiRepository extends CrudRepository<Defi, Integer>, WithInsert<Defi> {
	List<Defi> findByUid(String uid);

	List<Defi> findByIdArret(int idArret);
}
