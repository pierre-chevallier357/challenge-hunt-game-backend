package ttgxi.repository;

import ttgxi.entity.Indice;
import org.springframework.data.repository.CrudRepository;

public interface IndiceRepository extends CrudRepository<Indice, Integer>, WithInsert<Indice> {
}
