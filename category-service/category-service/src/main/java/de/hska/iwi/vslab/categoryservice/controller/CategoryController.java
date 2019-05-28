package de.hska.iwi.vslab.categoryservice.controller;


import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.hska.iwi.vslab.categoryservice.dao.Category;
import de.hska.iwi.vslab.categoryservice.dao.CategoryRepo;


@RestController
@RequestMapping(value = "categorys/")
public class CategoryController {

	@Autowired
	private CategoryRepo repo;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody String name) {
		// Create Category
		repo.save(new Category(name));
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Iterable<Category>> getCategories() {
		
		Iterable<Category> allCategories = repo.findAll();
		return new ResponseEntity<>(allCategories, HttpStatus.OK);
	
	}

	@GetMapping("{id}")
	public ResponseEntity<Category> getCategory(@PathVariable final long id) {
		
		Category category = repo.findById(id).orElseThrow(() -> new EntityNotFoundException());
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable final long id) {
		
		repo.deleteById(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
