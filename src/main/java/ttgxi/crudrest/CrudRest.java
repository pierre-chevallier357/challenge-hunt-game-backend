package ttgxi.crudrest;

import ttgxi.repository.WithInsert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

abstract public class CrudRest<T, ID, REPO extends CrudRepository<T, ID> & WithInsert<T>> {
	protected final REPO repository;

	public CrudRest(REPO repository) {
		this.repository = repository;
	}

	@GetMapping("/")
	public List<T> all() {
		return (List<T>) repository.findAll();
	}

	@GetMapping("/{id}")
	public T read(@PathVariable(value = "id") final ID id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/")
	public T create(@RequestBody T entity) {
		return repository.insert(entity);
	}

	@PutMapping("/{id}")
	public T update(@PathVariable(value = "id") ID id, @RequestBody T entity) {
		repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		return repository.save(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") ID id) {
		T entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		repository.delete(entity);
	}
}
