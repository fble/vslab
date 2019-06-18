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
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategoryRepo repo;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody String name) throws Exception {
		// Create Category
		if (name.length() == 0) {
			throw new IllegalArgumentException("Category must be given a name!");
		}
		repo.save(new Category(name));
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Category[]> getCategories() {
		
		Iterable<Category> allCategories = repo.findAll();
		
		Category[] testCats = new Category[1];
		testCats[0] = new Category("TESTCATEGORY");
		System.out.println("Get Categories called++++++++++++++++++++++++");
		return new ResponseEntity<Category[]>(testCats, HttpStatus.OK);
	
	}

	@GetMapping("{id}")
	public ResponseEntity<Category> getCategory(@PathVariable final long id) {
		System.out.println("Get Categoriy by id called++++++++++++++++++++++++");
		Category category = repo.findById(id).orElseThrow(() -> new EntityNotFoundException());
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable final long id) {
		
		repo.deleteById(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
