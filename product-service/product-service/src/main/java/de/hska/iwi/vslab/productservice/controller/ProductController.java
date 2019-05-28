package de.hska.iwi.vslab.productservice.controller;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.Response;

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

import de.hska.iwi.vslab.productservice.dao.Product;
import de.hska.iwi.vslab.productservice.dao.ProductRepo;

@RestController
@RequestMapping(value = "products/")
public class ProductController {
		
	@Autowired
	private ProductRepo repo;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Product product) {
		// Create Category
		repo.save(product);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Iterable<Product>> getProducts() {
		
		Iterable<Product> allProducts = repo.findAll();
		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	
	}

	@GetMapping("{id}")
	public ResponseEntity<Product> getProduct(@PathVariable final long id) {
		
		Product product = repo.findById(id).orElseThrow(() -> new EntityNotFoundException());
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable final long id) {
		
		repo.deleteById(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
