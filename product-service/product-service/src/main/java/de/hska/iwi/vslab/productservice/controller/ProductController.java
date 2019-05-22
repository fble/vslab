package de.hska.iwi.vslab.productservice.controller;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.hska.iwi.vslab.productservice.Product;

@RestController
@RequestMapping(value = "products/")
public class ProductController {

	@PostMapping
	public Response create() {
		// Create Product
		return Response.ok().build();
	}

	@GetMapping
	public List<Product> getProducts() {
		return Collections.emptyList();
	}

	@GetMapping("{id}")
	public Product getProduct(@PathVariable final String id) {
		return new Product();
	}

	@DeleteMapping("{id}")
	public Response delete(@PathVariable final String id) {
		// Delete Product
		return Response.ok().build();
	}

}
