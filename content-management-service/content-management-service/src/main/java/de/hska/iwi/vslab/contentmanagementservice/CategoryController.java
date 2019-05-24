package de.hska.iwi.vslab.contentmanagementservice;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categories")
public class CategoryController {

	@PostMapping
	public Response createCategory() {
		//TODO add new category
		
		return Response.ok().build();
	}
	
	@GetMapping
	public Response getCategory() {
		// Login user
		// TODO return category
		return Response.ok().build();
	}
	
	@GetMapping("{id}")
	public Response getCategoryById(@PathVariable String id) {
		// Logout user
		return Response.ok("ID"+id).build();
		//return Response.ok().build();
	}
	
	@DeleteMapping("{id}")
	public Response deleteCategoryById(@PathVariable String id) {
		// Logout user
		return Response.ok("Delete "+id).build();
		//return Response.ok().build();
	}
	
	@GetMapping("{id}/products")
	public Response getProducts(@PathVariable String id) {
		// Logout user
		return Response.ok("Products for "+id).build();
		//return Response.ok().build();
	}
	
}
