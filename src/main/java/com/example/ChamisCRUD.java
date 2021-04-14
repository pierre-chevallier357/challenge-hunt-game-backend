package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/chamis")
public class ChamisCRUD {
	@Autowired
	private ChamisRepository repository;

	@GetMapping("/")
	public List<Chamis> allChamis() {
		return (List<Chamis>) repository.findAll();
	}

	@GetMapping("/{ChamisId}")
	public Chamis read(@PathVariable(value = "ChamisId") final String id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/{ChamisId}")
	public Chamis create(@PathVariable(value = "ChamisId") String id, @RequestBody Chamis c) {
		if (!c.getLogin().equals(id)) {
			throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
		}

		repository.findById(id).ifPresent(found -> {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		});

		return repository.insert(c);
	}

	@PutMapping("/{ChamisId}")
	Chamis update(@PathVariable(value = "ChamisId") String id, @RequestBody Chamis c) {
		if (!c.getLogin().equals(id)) {
			throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
		}

		repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		return repository.save(c);
	}

	@DeleteMapping("/{ChamisId}")
	void delete(@PathVariable(value = "ChamisId") String id, HttpServletResponse response) {
		Chamis c = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		repository.delete(c);
	}
}
