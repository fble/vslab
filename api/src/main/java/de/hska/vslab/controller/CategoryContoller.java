package de.hska.vslab.controller;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.hska.vslab.ContentClient;
import de.hska.vslab.dataobjects.Category;

@RestController
@RequestMapping(value = "/categories/")
public class CategoryContoller {
	
	private final ContentClient client;
	
	@Autowired
	public CategoryContoller(final ContentClient client) {
		this.client = client;
	}
	
	
	@PostMapping
	public Response create(@RequestBody String name) {
		boolean success = client.createCategory(name);
		
		if (success)
			return Response.ok().build();

		return Response.serverError().build();
	}

	@GetMapping
	public Response getCategories() {
		Category[] c = client.getCategories();
		
		return Response.ok(c).build();
	}

	@GetMapping("{id}")
	public Response getCategory(@PathVariable final int id) {
		Category c = client.getCategoryById(id);
		
		return Response.ok(c).build();
	}

	@DeleteMapping("{id}")
	public Response deleteCategory(@PathVariable final int id) {
		boolean success = client.deleteCategory(id);
		
		if (success)
			return Response.ok().build();

		return Response.serverError().build();
	}

}

