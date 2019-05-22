package de.hska.iwi.vslab.categoryservice.controller;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.hska.iwi.vslab.categoryservice.Category;


@RestController
@RequestMapping(value = "categorys/")
public class CategoryController {

	@PostMapping
	public Response create() {
		// Create Category
		return Response.ok().build();
	}

	@GetMapping
	public List<Category> getCategorys() {
		return Collections.emptyList();
	}

	@GetMapping("{id}")
	public Category getCategory(@PathVariable final String id) {
		return new Category();
	}

	@DeleteMapping("{id}")
	public Response delete(@PathVariable final String id) {
		// Delete Category
		return Response.ok().build();
	}

}
